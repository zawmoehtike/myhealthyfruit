package com.zawmoehtike.data.datasource.fruits

import com.zawmoehtike.data.entity.FruitEntity

interface FruitCacheDataSource {
    fun getFruitDetail(id: String): FruitEntity

    fun getFruitList(currentPage: String): List<FruitEntity>

    fun saveFruitList(fruitList: List<FruitEntity>)
}