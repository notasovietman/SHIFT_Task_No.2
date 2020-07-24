package com.example.weatherrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_city_weather_list.*

class CityWeatherListActivity : AppCompatActivity() {

    private val cityWeatherList = generateCityList()
    private val adapter = CityWeatherAdapter(cityWeatherList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_weather_list)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        adapter.setListener(object : CityWeatherAdapter.WeatherListener {
            override fun onItemClick(model: CityWeatherItem) {
                val intent =
                    Intent(this@CityWeatherListActivity, CityWeatherDetailActivity::class.java)
                intent.putStringArrayListExtra("CityWeather", arrayListOf(model.city, model.temp, model.condition))
                startActivity(intent)
            }
        })
    }

    private fun generateCityList(): List<CityWeatherItem> {
        val cityList: List<CityWeatherItem> = listOf(
            CityWeatherItem(R.drawable.ic_sun, "Москва", "22°C", "Ясно"),
            CityWeatherItem(R.drawable.ic_cloud, "Cанкт-Петербург", "15°C", "Облачно"),
            CityWeatherItem(R.drawable.ic_rain, "Новосибирск", "26°C", "Дожди"),
            CityWeatherItem(R.drawable.ic_sun, "Красноярск", "32°C", "Ясно"),
            CityWeatherItem(R.drawable.ic_storm, "Иркутск", "27°C", "Грозы"),
            CityWeatherItem(R.drawable.ic_sun, "Краснодар", "36°C", "Ясно")
        )
        return cityList
    }
}