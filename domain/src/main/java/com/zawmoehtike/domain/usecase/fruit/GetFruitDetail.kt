package com.zawmoehtike.domain.usecase.fruit

import com.zawmoehtike.domain.CoroutineUseCase
import com.zawmoehtike.domain.model.FruitModel
import com.zawmoehtike.domain.repository.FruitRepository
import javax.inject.Inject

class GetFruitDetail @Inject constructor(
  private val fruitRepository: FruitRepository
) : CoroutineUseCase<GetFruitDetail.Params, FruitModel>() {

    data class Params(
        val id: String
    )

    override suspend fun provide(params: Params): FruitModel {
        return fruitRepository.getFruitDetail(params.id)
    }
}