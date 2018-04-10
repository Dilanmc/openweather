package com.example.dilan.openweather.ui.weather_day

import com.example.dilan.openweather.ui.Base.BasePresenterImpl
import com.example.dilan.openweather.utils.getFilters
import com.example.dilan.openweather.network.ApiManager
import com.example.dilan.openweather.network.GeneralErrorHandler
import rx.functions.Action1

/**
 * Created by dilan on 4/9/18.
 */
class WeatherDayPresenter : BasePresenterImpl<WeatherDayContract.View>(), WeatherDayContract.Presenter {

    override fun loadWeather() {
        ApiManager.loadWeather(getFilters())
                .doOnError({ mView?.showMessage(it.toString()) })
                .subscribe(Action1 { mView?.showWeather(it)},
                        GeneralErrorHandler(mView, true, { throwable, errorBody, isNetwork -> mView?.showError(throwable.message) }))

    }
}