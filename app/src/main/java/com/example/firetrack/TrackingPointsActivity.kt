package com.example.firetrack

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import com.example.firetrack.adapter.TrackingPointsAdapter
import com.example.firetrack.service.ApiServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TrackingPointsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TrackingPointsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracking_points)

        recyclerView = findViewById(R.id.trackingPointsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadTrackingPoints()
    }

    private fun loadTrackingPoints() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = ApiServices.trackingPointApiService.getTrackingPoints()
            if (response.isSuccessful && response.body() != null) {
                withContext(Dispatchers.Main) {
                    adapter = TrackingPointsAdapter(response.body()!!)
                    recyclerView.adapter = adapter
                }
            } else {
                Log.e("loadTrackingPoints", "loadTrackingPoints error")
            }
        }
    }


}
