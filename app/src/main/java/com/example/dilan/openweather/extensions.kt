package com.example.dilan.openweather

import android.support.design.widget.TabLayout
import android.view.View
import android.widget.ImageView
import com.squareup.moshi.Moshi
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


inline fun <reified T> Moshi.fromJson(json: String): T = this.adapter(T::class.java).fromJson(json)
val api_key: String = "973a6c0046d2fc5a445b2dfa82b4488e"

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
    parameters.put("APPID", api_key)
    parameters.put("q", "Bishkek")
    parameters.put("units", "metric")
    return parameters

}

fun humanizeDateMediumStyle(date: Date?): String {
    if (date != null) {
        var result = DateFormat.getDateInstance(DateFormat.MEDIUM).format(date)
        val days = diffDaysWithToday(date)
        val format = SimpleDateFormat("hh:mm", Locale.US)

        if (days == 0L)
            result = "today "
        else if (days == 1L)
            result = "tomorrow "
        else if (days == -1L)
            result = "yesterday "
        return result + " " + format.format(date)
    }
    return ""
}


fun diffDaysWithToday(date: Date?): Long {
    var days: Long = 0
    if (date != null) {
        val diff = dateWithoutTime(date).timeInMillis - today().timeInMillis
        days = diff / 1000 / 60 / 60 / 24
    }
    return days
}

private fun dateWithoutTime(date: Date): Calendar {
    val input = Calendar.getInstance()
    input.time = date
    input.set(Calendar.HOUR_OF_DAY, 0)
    input.set(Calendar.MINUTE, 0)
    input.set(Calendar.SECOND, 0)
    input.set(Calendar.MILLISECOND, 0)
    return input
}

private fun today(): Calendar {
    val now = Calendar.getInstance()
    now.set(Calendar.HOUR_OF_DAY, 0)
    now.set(Calendar.MINUTE, 0)
    now.set(Calendar.SECOND, 0)
    now.set(Calendar.MILLISECOND, 0)
    return now
}

fun String.formatDate(): String {
    val initialFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH)
    val date = initialFormat.parse(this)
    return humanizeDateMediumStyle(date)
}
