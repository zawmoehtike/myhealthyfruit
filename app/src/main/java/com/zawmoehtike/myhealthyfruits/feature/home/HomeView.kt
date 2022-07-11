package com.zawmoehtike.myhealthyfruits.feature.home

import androidx.lifecycle.MutableLiveData
import com.zawmoehtike.appbase.core.mvp.Viewable
import com.zawmoehtike.appbase.helper.AsyncViewResource

interface HomeView: Viewable {
    fun showFruitList(liveData: MutableLiveData<AsyncViewResource<List<FruitViewItem>>>)

    fun showError(message: String)
}