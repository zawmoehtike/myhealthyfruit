package com.zawmoehtike.myhealthyfruits.feature.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import com.zawmoehtike.appbase.core.mvp.MvpActivity
import com.zawmoehtike.appbase.helper.AsyncViewResource
import com.zawmoehtike.myhealthyfruits.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: MvpActivity<HomeView, HomeViewModel>(), HomeView {

    override val layoutResId: Int = R.layout.activity_main

    override val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getFruitList()
    }

    override fun showFruitList(liveData: MutableLiveData<AsyncViewResource<List<FruitViewItem>>>) {
        liveData.observe(this) {
            when (it) {
                is AsyncViewResource.Loading -> {
                    val loading = "loading..."
                }
                is AsyncViewResource.Success -> {
                    val success = it.value
                }
                is AsyncViewResource.Error -> {
                    val error = it.error
                }
            }
        }
    }

    override fun showError(message: String) {

    }
}