package com.zawmoehtike.data.repositoryimpl

import com.zawmoehtike.data.datasource.fruits.FruitCacheDataSource
import com.zawmoehtike.data.datasource.fruits.FruitNetworkDataSource
import com.zawmoehtike.data.entity.FruitEntity
import com.zawmoehtike.data.mapper.FruitEntityMapper
import com.zawmoehtike.domain.model.FruitModel
import com.zawmoehtike.domain.repository.FruitRepository
import javax.inject.Inject

class FruitRepositoryRealImpl @Inject constructor(
    private val fruitNetworkDataSource: FruitNetworkDataSource,
    private val fruitCacheDataSource: FruitCacheDataSource,
    private val fruitEntityMapper: FruitEntityMapper
) : FruitRepository {

    override suspend fun getCachedFruits(currentPage: String): List<FruitModel> {
        return fruitCacheDataSource.getFruitList(currentPage).map {
            fruitEntityMapper.map(it)
        }
    }

    override suspend fun getFruits(currentPage: String): List<FruitModel> {
        return fruitNetworkDataSource.getFruitList(currentPage)
            .apply {
                fruitCacheDataSource.saveFruitList(this)
            }.map {
                fruitEntityMapper.map(it)
            }
    }

    override suspend fun getFruitDetail(id: String): FruitModel {
        return try {
            val cacheData = fruitCacheDataSource.getFruitDetail(id)
            fruitEntityMapper.map(cacheData)
        } catch (throwable: Throwable) {
            val remoteData = fruitNetworkDataSource.getFruitDetail(id)
            fruitCacheDataSource.saveFruitList(listOf(remoteData) as List<FruitEntity>)
            val cacheData = fruitCacheDataSource.getFruitDetail(id)
            fruitEntityMapper.map(cacheData)
        }
    }
}