package com.example.weatherrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_city_weather_detail.*

class CityWeatherDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_weather_detail)

        val parameters = intent.getStringArrayListExtra("CityWeather")

        cityDetailText.text = parameters?.get(0)
        temperTextView.text = parameters?.get(1)
        conditionTextView.text = parameters?.get(2)

    }
}