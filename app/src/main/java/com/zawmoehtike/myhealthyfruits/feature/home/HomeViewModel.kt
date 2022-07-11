package com.zawmoehtike.myhealthyfruits.feature.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.zawmoehtike.appbase.core.mvp.BaseViewModel
import com.zawmoehtike.appbase.helper.AsyncViewResource
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

    private val fruitListLiveData = MutableLiveData<AsyncViewResource<List<FruitViewItem>>>()

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
                        .sortedByDescending { it.title }
                        .map {
                            FruitViewItem(
                                id = it.id,
                                title = it.title,
                                description = it.description,
                                vitamins = it.vitamins,
                                photoBitmap = it.photoBitmap
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