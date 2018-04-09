package com.example.dilan.openweather.Base


interface BasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}