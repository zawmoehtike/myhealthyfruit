package com.zawmoehtike.cache.mapper

import com.zawmoehtike.cache.Fruit
import com.zawmoehtike.data.entity.FruitEntity
import com.zawmoehtike.domain.mapper.UnidirectionalMap
import javax.inject.Inject

class FruitCacheMapper @Inject constructor() : UnidirectionalMap<Fruit, FruitEntity> {

    override fun map(item: Fruit): FruitEntity {
        return FruitEntity(
            id = item.id,
            title = item.title,
            description = item.description?:"",
            vitamins = item.vitamins?:"",
            photoBitmap = item.imageBitmap?:""
        )
    }
}