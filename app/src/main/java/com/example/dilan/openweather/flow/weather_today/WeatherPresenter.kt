package com.example.dilan.openweather.flow.weather_today

import com.example.dilan.openweather.Apikey
import com.example.dilan.openweather.Base.BasePresenterImpl
import com.example.dilan.openweather.network.ApiManager
import com.example.dilan.openweather.network.GeneralErrorHandler
import rx.functions.Action1
import java.util.*

/**
 * Created by dilan on 4/9/18.
 */
class WeatherPresenter : BasePresenterImpl<WeatherContract.View>(), WeatherContract.Presenter {
    override fun loadListWeather() {
        ApiManager.loadListWeather(getFilters())
                .doOnError({ mView?.showMessage(it.toString()) })
                .subscribe(Action1 { mView?.showListWeather(it) },
                        GeneralErrorHandler(mView, true, { throwable, errorBody, isNetwork -> mView?.showError(throwable.message) }))

    }

    override fun loadWeather() {
//        ApiManager.loadWeather(getFilters())
//                .doOnError({ mView?.showMessage(it.toString()) })
//                .subscribe(Action1 { mView?.showWeather(it)},
//                        GeneralErrorHandler(mView, true, { throwable, errorBody, isNetwork -> mView?.showError(throwable.message) }))

    }

    private fun getFilters(): Map<String, String> {
        val parameters = HashMap<String, String>()
        parameters.put("APPID", Apikey.API_KEY)
        parameters.put("q", "Bishkek")
        parameters.put("units", "metric")
        return parameters
    }
}

