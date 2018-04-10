package com.example.dilan.openweather.ui.weather_list

import com.example.dilan.openweather.getFilters
import com.example.dilan.openweather.ui.Base.BasePresenterImpl
import com.example.dilan.openweather.network.ApiManager
import com.example.dilan.openweather.network.GeneralErrorHandler
import rx.functions.Action1

/**
 * Created by dilan on 4/9/18.
 */
class WeatherListPresenter : BasePresenterImpl<WeatherListContract.View>(), WeatherListContract.Presenter {
    override fun loadListWeather() {
        ApiManager.loadListWeather(getFilters())
                .doOnError({ mView?.showMessage(it.toString()) })
                .subscribe(Action1 { mView?.showListWeather(it) },
                        GeneralErrorHandler(mView, true, { throwable, errorBody, isNetwork -> mView?.showError(throwable.message) }))

    }


}

