package com.example.dilan.openweather.model

import com.squareup.moshi.Json

class WeatherModel(val id: Int, val name: String, @Json(name = "dt_txt") val dtTxt: String, val main: Data, val weather: List<WeatherDetail>)