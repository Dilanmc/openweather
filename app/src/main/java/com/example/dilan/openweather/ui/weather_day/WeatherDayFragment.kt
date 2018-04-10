package com.example.dilan.openweather.ui.weather_day

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.example.dilan.openweather.R
import com.example.dilan.openweather.model.WeatherModel
import com.example.dilan.openweather.ui.Base.BaseFragment
import kotlinx.android.synthetic.main.fragment_weather_detail.*

class WeatherDayFragment : BaseFragment<WeatherDayContract.View, WeatherDayPresenter>(), WeatherDayContract.View {
    companion object {
        fun newInstance(): WeatherDayFragment {
            return WeatherDayFragment()
        }
    }

    override var mPresenter: WeatherDayPresenter = WeatherDayPresenter()

    override fun getLayout(): Int {
        return R.layout.fragment_weather_detail
    }

    @SuppressLint("SetTextI18n")
    override fun showWeather(weather: WeatherModel) {
        temp.text = weather.main.temp.toString() + "℃"
        pressure.text = String.format("Pressure " + weather.main.pressure)
        city.text = weather.name
        hideProgress()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.loadWeather()
        showProgress()

    }

    private fun showProgress() {
        temp.visibility = View.GONE
        city.visibility = View.GONE
        progress_bar_detail.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        temp.visibility = View.VISIBLE
        city.visibility = View.VISIBLE
        progress_bar_detail.visibility = View.GONE
    }
}