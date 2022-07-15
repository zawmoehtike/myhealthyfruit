package com.zawmoehtike.domain.repository

import com.zawmoehtike.domain.model.FruitModel

interface FruitRepository {
    suspend fun getCachedFruits(currentPage: String): List<FruitModel>

    suspend fun getFruits(currentPage: String): List<FruitModel>

    suspend fun getFruitDetail(id: String): FruitModel
}