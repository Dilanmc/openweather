package com.example.dilan.openweather.network

import com.example.dilan.openweather.model.WeatherList
import com.example.dilan.openweather.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.QueryMap
import rx.Observable

/**
 * Created by dilan on 4/9/18.
 */
interface ServiceApi {

    @GET("weather")
    fun getWeather(@QueryMap parameters: Map<String, String>): Observable<WeatherModel>

    @GET("forecast")
    fun getListWeather(@QueryMap parameters: Map<String, String>): Observable<WeatherList>
}