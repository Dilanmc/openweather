package com.example.dilan.openweather.ui.weather_day

import com.example.dilan.openweather.ui.Base.BasePresenter
import com.example.dilan.openweather.ui.Base.BaseContract
import com.example.dilan.openweather.model.WeatherModel

/**
 * Created by dilan on 4/9/18.
 */
object WeatherDayContract {
    interface View : BaseContract {
        fun showWeather(weather: WeatherModel)
    }
    interface Presenter : BasePresenter<View> {
        fun loadWeather()

    }
}