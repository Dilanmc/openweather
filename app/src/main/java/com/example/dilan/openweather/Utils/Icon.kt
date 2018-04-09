package com.example.dilan.openweather.Utils

import android.widget.ImageView
import com.example.dilan.openweather.R

/**
 * Created by dilan on 4/9/18.
 */
object Icon {
    fun getIcon(icon: String, view: ImageView) {
        when (icon) {
            "light snow" -> view.setImageResource(R.drawable.icons8_light_snow_50)
            "clear sky" -> view.setImageResource(R.drawable.sunny_256)
            "snow" -> view.setImageResource(R.drawable.icons8_snow_50)
            "few clouds" -> view.setImageResource(R.drawable.a_few_clouds)
        }
    }
}