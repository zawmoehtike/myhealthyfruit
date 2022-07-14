package com.zawmoehtike.network.service

import com.zawmoehtike.network.response.fruit.FruitResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MyHealthyFruitsService {

    // http://myjson.dit.upm.es/api/bins/475f
    @GET("475f")
    suspend fun getFruitList(
        @Query("page") page: String
    ): Response<FruitResponse>

}