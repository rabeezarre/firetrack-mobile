package com.example.firetrack.service

import com.example.firetrack.model.TrackingPoint
import retrofit2.Response
import retrofit2.http.GET

interface TrackingPointApiService {
    @GET("trackingPoints")
    suspend fun getTrackingPoints(): Response<List<TrackingPoint>>
}

