package com.zawmoehtike.cache.datasource

import com.zawmoehtike.cache.MyHealthyFruitsDB
import com.zawmoehtike.cache.mapper.FruitCacheMapper
import com.zawmoehtike.data.datasource.fruits.FruitCacheDataSource
import com.zawmoehtike.data.entity.FruitEntity
import javax.inject.Inject

class FruitCacheDataSourceRealImpl @Inject constructor(
    private val db: MyHealthyFruitsDB,
    private val fruitCacheMapper: FruitCacheMapper
): FruitCacheDataSource {
    override fun getFruitDetail(id: String): FruitEntity {
        return fruitCacheMapper.map(db.fruitQueries.selectById(id).executeAsOne())
    }

    override fun getFruitList(currentPage: String): List<FruitEntity> {
        return db.fruitQueries.selectAll().executeAsList().map(fruitCacheMapper::map)
    }

    override fun saveFruitList(fruitList: List<FruitEntity>) {
        db.transaction {
            fruitList.forEach {
                db.fruitQueries.insertOrReplace(
                    id = it.id,
                    title = it.title,
                    description = it.description,
                    vitamins = it.vitamins,
                    imageBitmap = it.photoBitmap
                )
            }
        }
    }

}