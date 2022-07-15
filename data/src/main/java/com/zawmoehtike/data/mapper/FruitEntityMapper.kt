package com.zawmoehtike.data.mapper

import com.zawmoehtike.data.entity.FruitEntity
import com.zawmoehtike.domain.mapper.UnidirectionalMap
import com.zawmoehtike.domain.model.FruitModel
import javax.inject.Inject

class FruitEntityMapper @Inject constructor() : UnidirectionalMap<FruitEntity, FruitModel> {
    override fun map(item: FruitEntity): FruitModel {
        return FruitModel(
            id = item.id,
            name = item.name,
            genus = item.genus,
            family = item.family,
            order = item.order
        )
    }
}