package com.zawmoehtike.myhealthyfruits.feature.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zawmoehtike.appbase.core.mvp.MvpActivity
import com.zawmoehtike.appbase.helper.AsyncViewResource
import com.zawmoehtike.domain.model.FruitModel
import com.zawmoehtike.myhealthyfruits.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity: MvpActivity<HomeView, HomeViewModel>(), HomeView {

    override val layoutResId: Int = R.layout.activity_main

    override val viewModel: HomeViewModel by viewModels()

    private val adapter by lazy {
        FruitListAdapter(object : FruitListAdapter.FruitListListener{
            override fun onClickFruit(client: FruitModel) {

            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvFruits.layoutManager = layoutManager
        rvFruits.adapter = adapter

        viewModel.getFruitList()
    }

    override fun showFruitList(liveData: MutableLiveData<AsyncViewResource<List<FruitModel>>>) {
        liveData.observe(this) {
            when (it) {
                is AsyncViewResource.Loading -> {
                    val loading = "loading..."
                }
                is AsyncViewResource.Success -> {
                    adapter.submitList(it.value)
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