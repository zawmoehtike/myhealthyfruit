package com.zawmoehtike.network.mapper

import com.zawmoehtike.data.entity.FruitEntity
import com.zawmoehtike.domain.mapper.UnidirectionalMap
import com.zawmoehtike.network.response.fruit.Fruit
import javax.inject.Inject

class FruitNetworkMapper @Inject constructor(): UnidirectionalMap<Fruit, FruitEntity> {

    override fun map(item: Fruit): FruitEntity {
        return FruitEntity(
            id = item.id,
            name = item.name,
            genus = item.genus,
            family = item.family,
            order = item.order
        )
    }
}