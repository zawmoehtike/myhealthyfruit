package com.zawmoehtike.network.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenericResponse(
    @Json(name = "status") val status: Int = 0,
    @Json(name = "message") val message: String? = null
)
