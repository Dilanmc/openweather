package com.example.dilan.openweather.ui.weather_list

import com.example.dilan.openweather.ui.Base.BasePresenter
import com.example.dilan.openweather.ui.Base.BaseContract
import com.example.dilan.openweather.model.WeatherList

/**
 * Created by dilan on 4/9/18.
 */
object WeatherListContract {
    interface View : BaseContract {
        fun showListWeather(list: WeatherList)
    }

    interface Presenter : BasePresenter<View> {
        fun loadListWeather()
    }

}