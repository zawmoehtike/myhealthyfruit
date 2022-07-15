package com.zawmoehtike.network.response.fruit

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FruitResponse(
    @Json(name = "data") val data: List<Fruit>? = null
)

/*
{
    "genus": "Malus",
    "name": "Apple",
    "id": 6,
    "family": "Rosaceae",
    "order": "Rosales",
    "nutritions": {
        "carbohydrates": 11.4,
        "protein": 0.3,
        "fat": 0.4,
        "calories": 52,
        "sugar": 10.3
    }
}
 */
@JsonClass(generateAdapter = true)
data class Fruit(
    @Json(name = "id") val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "genus") val genus: String,
    @Json(name = "family") val family: String,
    @Json(name = "order") val order: String,
    @Json(name = "nutritions") val nutritions: Nutrition,
)

@JsonClass(generateAdapter = true)
data class Nutrition(
    @Json(name = "carbohydrates") val carbohydrates: String,
    @Json(name = "protein") val protein: String,
    @Json(name = "fat") val fat: String,
    @Json(name = "calories") val calories: String,
    @Json(name = "sugar") val sugar: String
)


