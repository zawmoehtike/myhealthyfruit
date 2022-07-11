package com.zawmoehtike.appbase.core.mvp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import timber.log.Timber


abstract class BaseViewModel<viewable : Viewable> : ViewModel(), Presentable<viewable> {

    protected var view: viewable? = null

    protected val loggingExceptionHandler = CoroutineExceptionHandler { _, t ->
        Timber.i(t)
    }

    override fun attachView(viewable: viewable) {
        this.view = viewable
    }

    override fun detachView() {
        this.view = null
    }


    override fun onCleared() {
        super.onCleared()
    }

}