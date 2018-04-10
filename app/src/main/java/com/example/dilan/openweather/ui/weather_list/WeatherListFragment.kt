package com.example.dilan.openweather.ui.weather_list

import android.annotation.TargetApi
import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.dilan.openweather.R
import com.example.dilan.openweather.model.WeatherList
import com.example.dilan.openweather.model.WeatherModel
import com.example.dilan.openweather.ui.Base.BaseFragment
import kotlinx.android.synthetic.main.fragment_weather_list.*
import java.util.*


class WeatherListFragment : BaseFragment<WeatherListContract.View, WeatherListPresenter>(), WeatherListContract.View {
    companion object {
        fun newInstance(): WeatherListFragment {
            return WeatherListFragment()
        }
    }

    override var mPresenter: WeatherListPresenter = WeatherListPresenter()
    private var mAdapter: WeatherAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.loadListWeather()
        setUpRecyclerView()
        setUpFloatingButton()
        showProgress()
    }

    override fun showListWeather(list: WeatherList) {
        mAdapter?.addWeather(list.list)
        mAdapter?.notifyDataSetChanged()
        hideProgress()
    }


    override fun getLayout(): Int {
        return R.layout.fragment_weather_list
    }

    @TargetApi(Build.VERSION_CODES.N)
    private fun setUpFloatingButton() {
        fab.setOnClickListener({
            DatePickerDialog(activity).show()
        })
    }

    private fun setUpRecyclerView() {
        mAdapter = WeatherAdapter(ArrayList<WeatherModel>())
        recyclerViewWeather.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerViewWeather.adapter = mAdapter

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