package com.zawmoehtike.network.datasource.fruits

import com.zawmoehtike.data.datasource.fruits.FruitNetworkDataSource
import com.zawmoehtike.data.entity.FruitEntity
import com.zawmoehtike.network.getBodyOrThrowNetworkException
import com.zawmoehtike.network.mapper.FruitNetworkMapper
import com.zawmoehtike.network.service.MyHealthyFruitsService
import javax.inject.Inject

class FruitNetworkDataSourceRealImpl @Inject constructor(
    private val myHealthyFruitsService: MyHealthyFruitsService,
    private val fruitNetworkMapper: FruitNetworkMapper
): FruitNetworkDataSource {

    override suspend fun getFruitList(currentPage: String): List<FruitEntity> {
        val res = myHealthyFruitsService.getFruitList(currentPage)
            .getBodyOrThrowNetworkException()
        return if (res.isNullOrEmpty()) {
            emptyList()
        } else {
            res.map {
                fruitNetworkMapper.map(it)
            }
        }
    }

    override suspend fun getFruitDetail(id: String): FruitEntity? {
        val res = myHealthyFruitsService.getFruitList(id)
            .getBodyOrThrowNetworkException()
        return if (res.isNullOrEmpty()) {
            null
        } else {
            fruitNetworkMapper.map(res.first())
        }
    }
}