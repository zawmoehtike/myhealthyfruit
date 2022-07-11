package com.zawmoehtike.network.response.fruit

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FruitResponse(
    @Json(name = "data") val data: List<Fruit>? = null
)

@JsonClass(generateAdapter = true)
data class Fruit(
    @Json(name = "id") val id: String,
    @Json(name = "title") val title: String,
    @Json(name = "description") val description: String,
    @Json(name = "vitamins") val vitamins: String? = null,
    @Json(name = "photoBitmap") val photoBitmap: String? = null
)


