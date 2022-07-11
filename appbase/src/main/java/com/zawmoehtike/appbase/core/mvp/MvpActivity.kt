package com.zawmoehtike.appbase.core.mvp

import android.os.Bundle
import com.zawmoehtike.appbase.core.BaseActivity
import timber.log.Timber

/**
 * Created by Vincent on 12/6/18
 */
abstract class MvpActivity<V : Viewable, VM : BaseViewModel<V>> :
    BaseActivity() {

    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            viewModel.attachView(this as V)
        } catch (exception: Exception) {
            Timber.e(exception)
            throw InvalidMvpImplementationException()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.detachView()
    }
}
