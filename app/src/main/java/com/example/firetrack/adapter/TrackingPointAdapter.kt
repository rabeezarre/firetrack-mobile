package com.example.firetrack.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firetrack.R
import com.example.firetrack.TrackingPointDetailActivity
import com.example.firetrack.model.TrackingPoint

class TrackingPointsAdapter(private val trackingPoints: List<TrackingPoint>) :
    RecyclerView.Adapter<TrackingPointsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pointIdTextView: TextView = view.findViewById(R.id.pointIdTextView)
        val latitudeTextView: TextView = view.findViewById(R.id.latitudeTextView)
        val longitudeTextView: TextView = view.findViewById(R.id.longitudeTextView)
        val statusTextView: TextView = view.findViewById(R.id.statusTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tracking_point_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trackingPoint = trackingPoints[position]
        holder.pointIdTextView.text = trackingPoint.pointId.toString()
        holder.latitudeTextView.text = trackingPoint.latitude.toString()
        holder.longitudeTextView.text = trackingPoint.longitude.toString()
        holder.statusTextView.text = trackingPoint.status

        // Set the click listener
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, TrackingPointDetailActivity::class.java).apply {
                putExtra("pointId", trackingPoint.pointId)
                putExtra("pointLatitude", trackingPoint.latitude)
                putExtra("pointLongitude", trackingPoint.longitude)
                putExtra("pointStatus", trackingPoint.status)
            }
            it.context.startActivity(intent)
        }
    }


    override fun getItemCount() = trackingPoints.size
}
