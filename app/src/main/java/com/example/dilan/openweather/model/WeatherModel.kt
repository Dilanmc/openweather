package com.example.dilan.openweather.model

class WeatherModel(val id: Int, val name: String, val dt_txt: String, val main: Data, val weather: List<WeatherDetail>)