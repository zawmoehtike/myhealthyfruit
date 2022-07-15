package com.zawmoehtike.myhealthyfruits.feature.home

import androidx.lifecycle.MutableLiveData
import com.zawmoehtike.appbase.core.mvp.Viewable
import com.zawmoehtike.appbase.helper.AsyncViewResource
import com.zawmoehtike.domain.model.FruitModel

interface HomeView: Viewable {
    fun showFruitList(liveData: MutableLiveData<AsyncViewResource<List<FruitModel>>>)

    fun showError(message: String)
}