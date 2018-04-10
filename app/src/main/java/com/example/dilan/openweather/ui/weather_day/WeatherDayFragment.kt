package com.example.dilan.openweather.ui.weather_day

import android.os.Bundle
import android.view.View
import com.example.dilan.openweather.R
import com.example.dilan.openweather.model.WeatherModel
import com.example.dilan.openweather.ui.Base.BaseFragment
import kotlinx.android.synthetic.main.fragment_weather_detail.*

/**
 * Created by dilan on 4/9/18.
 */
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

    override fun showWeather(weather: WeatherModel) {
        name.text = weather.name

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.loadWeather()
    }

}