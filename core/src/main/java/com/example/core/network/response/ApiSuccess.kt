package com.example.core.network.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiSuccess(
    @Json(name = "details")
    val details: String?
)