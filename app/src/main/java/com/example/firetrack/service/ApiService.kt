package com.example.firetrack.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServices {
    private const val BASE_URL = "https://firetrack.cleverapps.io/api/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val userApiService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }

    val trackingPointApiService: TrackingPointApiService by lazy {
        retrofit.create(TrackingPointApiService::class.java)
    }

    val scanningHistoryApiService: ScanningHistoryApiService by lazy {
        retrofit.create(ScanningHistoryApiService::class.java)
    }

}


