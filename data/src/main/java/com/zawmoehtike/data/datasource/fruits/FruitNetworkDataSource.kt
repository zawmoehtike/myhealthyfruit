package com.zawmoehtike.data.datasource.fruits

import com.zawmoehtike.data.entity.FruitEntity

interface FruitNetworkDataSource {
    suspend fun getFruitList(currentPage: String): List<FruitEntity>

    suspend fun getFruitDetail(id: String): FruitEntity?
}