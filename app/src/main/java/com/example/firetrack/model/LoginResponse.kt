package com.example.firetrack.model

data class LoginResponse(
    val userId: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val position: String,
    val role: String
)
