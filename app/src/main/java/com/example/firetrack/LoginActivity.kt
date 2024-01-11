package com.example.firetrack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.firetrack.model.LoginRequest
import com.example.firetrack.service.ApiServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.email)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login_button)
        val errorTextView = findViewById<TextView>(R.id.login_error)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateInput(email, password)) {
                performLogin(email, password, errorTextView)
            } else {
                errorTextView.visibility = View.VISIBLE
                errorTextView.text = "Invalid Input"
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        // Add your input validation logic here
        return email.isNotEmpty() && password.isNotEmpty()
    }


    private fun performLogin(email: String, password: String, errorTextView: TextView) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = ApiServices.userApiService.login(LoginRequest(email, password))
                if (response.isSuccessful && response.body() != null) {
                    // Switching to the main thread to start a new activity
                    withContext(Dispatchers.Main) {
                        openTrackingPointsActivity()
                    }
                } else {
                    // Handle login failure
                    withContext(Dispatchers.Main) {
                        errorTextView.text = "Login Failed: ${response.errorBody()?.string()}"
                        errorTextView.visibility = View.VISIBLE
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    errorTextView.text = "Login Failed: ${e.message}"
                    errorTextView.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun openTrackingPointsActivity() {
        val intent = Intent(this, TrackingPointsActivity::class.java)
        startActivity(intent)
        finish() // Optional: Call finish() if you don't want to return to the login screen when back is pressed
    }

}


