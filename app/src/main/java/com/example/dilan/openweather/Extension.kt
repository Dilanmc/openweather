package com.example.dilan.openweather

import android.view.View
import com.squareup.moshi.Moshi
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by dilan on 4/9/18.
 */
inline fun <reified T> Moshi.fromJson(json: String): T = this.adapter(T::class.java).fromJson(json)

interface LayoutContainer {
    val containerView: View?

    fun String.formatDate(): String {
        val initialFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss ")
        val format = SimpleDateFormat("yyyy-M-dd", Locale.getDefault())
        val date = initialFormat.parse(this)
        return format.format(date).toString()
    }
}