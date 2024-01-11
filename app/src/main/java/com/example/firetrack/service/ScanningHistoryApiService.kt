package com.example.firetrack.service

import com.example.firetrack.model.ScanningHistory
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ScanningHistoryApiService {
    @POST("scanningHistory")
    suspend fun postScanningHistory(@Body scanningHistory: ScanningHistory): Response<Void>
}
