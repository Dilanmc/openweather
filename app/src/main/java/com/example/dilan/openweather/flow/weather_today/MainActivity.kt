package com.example.dilan.openweather.flow.weather_today

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.dilan.openweather.Base.BaseActivity
import com.example.dilan.openweather.R
import com.example.dilan.openweather.model.WeatherList
import com.example.dilan.openweather.model.WeatherModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity<WeatherContract.View, WeatherPresenter>(), WeatherContract.View {
    override fun showListWeather(list: WeatherList) {
        mAdapter?.addWeather(list.list)
        mAdapter?.notifyDataSetChanged()
        hideProgress()
    }


    override var mPresenter: WeatherPresenter = WeatherPresenter()
    private var mAdapter: WeatherAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showProgress()
        setUpRecyclerView()
        mPresenter.loadListWeather()

    }

    private fun setUpRecyclerView() {
        mAdapter = WeatherAdapter(ArrayList<WeatherModel>())
        recyclerViewWeather.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewWeather.adapter = mAdapter

    }

    override fun showWeather(weather: WeatherModel) {
//        hideProgress()
    }

    override fun showError(error: String?) {
        super.showError(error)
        recyclerViewWeather.visibility = View.GONE
        progress_bar.visibility = View.VISIBLE

    }

    private fun showProgress() {
        recyclerViewWeather.visibility = View.GONE
        progress_bar.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        recyclerViewWeather.visibility = View.VISIBLE
        progress_bar.visibility = View.GONE
    }
}
