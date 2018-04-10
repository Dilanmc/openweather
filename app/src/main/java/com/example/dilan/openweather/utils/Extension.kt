package com.example.dilan.openweather.utils

import android.support.design.widget.TabLayout
import android.view.View
import android.widget.ImageView
import com.example.dilan.openweather.Apikey
import com.example.dilan.openweather.R
import com.squareup.moshi.Moshi
import java.util.*


inline fun <reified T> Moshi.fromJson(json: String): T = this.adapter(T::class.java).fromJson(json)

interface LayoutContainer {
    val containerView: View?
}

fun addTabs(tabs: TabLayout, title: String) {
    tabs.addTab(tabs.newTab().setText(title))

}

fun getIcon(icon: String, view: ImageView) {
    when (icon) {
        "light snow" -> view.setImageResource(R.drawable.icons8_light_snow_50)
        "clear sky" -> view.setImageResource(R.drawable.sunny_256)
        "snow" -> view.setImageResource(R.drawable.snowflake_256)
        "few clouds" -> view.setImageResource(R.drawable.a_few_clouds)
    }
}

fun getFilters(): Map<String, String> {
    val parameters = HashMap<String, String>()
    parameters.put("APPID", Apikey.API_KEY)
    parameters.put("q", "Bishkek")
    parameters.put("units", "metric")
    return parameters
}