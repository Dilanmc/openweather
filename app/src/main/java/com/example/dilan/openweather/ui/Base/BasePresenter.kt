package com.example.dilan.openweather.ui.Base


interface BasePresenter<in V : BaseContract> {

    fun attachView(view: V)

    fun detachView()
}