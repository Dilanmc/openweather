package com.example.dilan.openweather.model

import com.squareup.moshi.Json

class Data(val temp: Double, @Json(name = "temp_max") val tempMax: Double,@Json(name = "temp_min") val  tempMin: Double, val pressure: Double)