package com.example.weatherrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.city_weather_item.view.*

class CityWeatherAdapter(private val cityWeatherList: List<CityWeatherItem>) :
    RecyclerView.Adapter<CityWeatherAdapter.ViewHolder>() {

    private var weatherListener: WeatherListener? = null

    class ViewHolder(itemView: View, private val weatherListener: WeatherListener?) :
        RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.image_view_sun
        private val city: TextView = itemView.cityWeather
        private val cityTemp: TextView = itemView.cityTemperature
        private val weatherCondition: TextView = itemView.weatherCondition

        fun bind(model: CityWeatherItem) {

            imageView.setImageResource(model.imageResource)
            city.text = model.city
            cityTemp.text = model.temp
            weatherCondition.text = model.condition

            itemView.setOnClickListener {
                weatherListener?.onItemClick(model)
            }
        }

    }

    fun setListener(listener: WeatherListener) {
        weatherListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.city_weather_item,
            parent, false
        )

        return ViewHolder(itemView, weatherListener)
    }

    override fun getItemCount() = cityWeatherList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(model = cityWeatherList[position])
    }

    interface WeatherListener {
        fun onItemClick(model: CityWeatherItem)
    }
}