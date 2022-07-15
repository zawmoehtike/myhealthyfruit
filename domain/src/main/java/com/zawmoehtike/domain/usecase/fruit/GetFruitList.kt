package com.zawmoehtike.domain.usecase.fruit

import com.zawmoehtike.domain.CoroutineUseCase
import com.zawmoehtike.domain.model.FruitModel
import com.zawmoehtike.domain.repository.FruitRepository
import javax.inject.Inject

class GetFruitList @Inject constructor(
    private val fruitRepository: FruitRepository
) : CoroutineUseCase<GetFruitList.Params, List<FruitModel>>() {

    data class Params(
        val currentPage: Int
    )

    override suspend fun provide(params: Params): List<FruitModel> {
        val cachedFruits = fruitRepository.getCachedFruits(params.currentPage.toString())
        if(cachedFruits.size == 0) {
            return fruitRepository.getFruits(params.currentPage.toString())
        } else {
            return cachedFruits
        }
    }

}