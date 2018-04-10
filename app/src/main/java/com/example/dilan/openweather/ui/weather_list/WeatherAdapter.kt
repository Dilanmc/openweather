package com.example.dilan.openweather.ui.weather_list


import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dilan.openweather.R
import com.example.dilan.openweather.LayoutContainer
import com.example.dilan.openweather.getIcon
import com.example.dilan.openweather.model.WeatherModel
import kotlinx.android.synthetic.main.item_weather.view.*


class WeatherAdapter(private val weathers: MutableList<WeatherModel>) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
                .inflate(R.layout.item_weather, parent, false).let {
            ViewHolder(it)
        }
    }

    override fun getItemCount(): Int = weathers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(weathers[position])
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        @SuppressLint("SetTextI18n")
        fun bindData(weatherModel: WeatherModel) {
            with(weatherModel) {
                containerView.date.text = weatherModel.dtTxt
                containerView.tempMax.text = String.format("%.2f", weatherModel.main.tempMax) + " ℃"
                containerView.tempMin.text = String.format("%.2f", weatherModel.main.tempMin) + " ℃"
                containerView.weather.text = weatherModel.weather[0].description
                getIcon(weatherModel.weather[0].description, containerView.icon_weather)
            }

        }
    }

    fun addWeather(newWeather: List<WeatherModel>) {
        weathers.addAll(newWeather)
    }
}