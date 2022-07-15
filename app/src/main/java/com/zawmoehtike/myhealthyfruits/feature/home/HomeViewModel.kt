package com.zawmoehtike.myhealthyfruits.feature.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zawmoehtike.appbase.core.mvp.BaseViewModel
import com.zawmoehtike.appbase.helper.AsyncViewResource
import com.zawmoehtike.domain.model.FruitModel
import com.zawmoehtike.domain.usecase.fruit.GetFruitDetail
import com.zawmoehtike.domain.usecase.fruit.GetFruitList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getFruitList: GetFruitList,
    private val getFruitDetail: GetFruitDetail
): BaseViewModel<HomeView>() {

    private val fruitListLiveData = MutableLiveData<AsyncViewResource<List<FruitModel>>>()

    override fun attachView(viewable: HomeView) {
        super.attachView(viewable)
        view?.showFruitList(fruitListLiveData)
    }

    fun getFruitList() {
        viewModelScope.launch {
            try {
                val result = getFruitList.execute(GetFruitList.Params(1))
                val viewItemList =
                    result
                        .sortedByDescending { it.name }
                        .map {
                            FruitModel(
                                id = it.id,
                                name = it.name,
                                genus = it.genus,
                                family = it.family,
                                order = it.order
                            )
                        }

                fruitListLiveData.postValue(AsyncViewResource.Success(viewItemList))
            } catch (t: Throwable) {
                fruitListLiveData.postValue(
                    AsyncViewResource.Error(
                        t,
                        errorMessage = "Error!"
                    )
                )
            }
        }
    }
}