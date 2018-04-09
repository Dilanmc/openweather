package com.example.dilan.openweather.flow.weather_today

import com.example.dilan.openweather.Base.BasePresenter
import com.example.dilan.openweather.Base.BaseView
import com.example.dilan.openweather.model.WeatherList
import com.example.dilan.openweather.model.WeatherModel

/**
 * Created by dilan on 4/9/18.
 */
object WeatherContract {
    interface View : BaseView {
        fun showWeather(weather: WeatherModel)
        fun showListWeather(list: WeatherList)
    }

    interface Presenter : BasePresenter<View> {
        fun loadWeather()
        fun loadListWeather()
    }

}