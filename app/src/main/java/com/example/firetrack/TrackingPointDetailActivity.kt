package com.example.firetrack

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.firetrack.model.ScanningHistory
import com.example.firetrack.service.ApiServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TrackingPointDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracking_point)

        // Get data passed from TrackingPointsActivity
        val pointId = intent.getIntExtra("pointId", -1)
        val latitude = intent.getDoubleExtra("pointLatitude", -1.0)
        val longitude = intent.getDoubleExtra("pointLongitude", -1.0)
        val status = intent.getStringExtra("pointStatus")

        // Display tracking point details
        val textViewId: TextView = findViewById(R.id.textViewId)
        val textViewLatitude: TextView = findViewById(R.id.textViewLatitude)
        val textViewLongitude: TextView = findViewById(R.id.textViewLongitude)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)

        textViewId.text = "Point ID: $pointId"
        textViewLatitude.text = "Latitude: $latitude"
        textViewLongitude.text = "Longitude: $longitude"
        textViewStatus.text = "Status: $status"

        val scanButton: Button = findViewById(R.id.scanButton)

        scanButton.setOnClickListener {
            val pointId = pointId
            val userId = 2 // Set the user ID accordingly
            val timestamp = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault()).format(
                Date()
            )

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val response = ApiServices.scanningHistoryApiService.postScanningHistory(
                        ScanningHistory(pointId, userId, timestamp)
                    )
                    if (response.isSuccessful) {
                        postScanningSuccess();
                    } else {
                        Log.e("scanButton", "response is not successful")
                    }
                } catch (e: Exception) {
                    Log.e("scanButton", "exception", e)
                }
            }
        }

    }

    private fun postScanningSuccess() {
        runOnUiThread {
            AlertDialog.Builder(this)
                .setTitle("Scanning Successful")
                .setMessage("The point has been successfully scanned.")
                .setPositiveButton("OK", null)
                .show()
        }
    }



}
