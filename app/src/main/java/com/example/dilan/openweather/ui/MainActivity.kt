package com.example.dilan.openweather.ui

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.example.dilan.openweather.ui.Base.BaseActivity
import com.example.dilan.openweather.R
import com.example.dilan.openweather.utils.PagerAdapter
import com.example.dilan.openweather.utils.addTabs
import com.example.dilan.openweather.ui.weather_day.WeatherDayFragment
import com.example.dilan.openweather.ui.weather_list.WeatherListFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseActivity() {
    private val fragments = ArrayList<Fragment>()

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragments.add(WeatherDayFragment.newInstance())
        fragments.add(WeatherListFragment.newInstance())

        pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))

        addTabs(tabs,getString(R.string.today))
        addTabs(tabs,getString(R.string.week))

        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        pager.adapter = PagerAdapter(supportFragmentManager, fragments)
    }

}
