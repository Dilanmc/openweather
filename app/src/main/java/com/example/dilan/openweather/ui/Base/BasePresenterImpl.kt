package com.example.dilan.openweather.ui.Base


open class BasePresenterImpl<V : BaseContract> : BasePresenter<V> {

    protected var mView: V? = null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}