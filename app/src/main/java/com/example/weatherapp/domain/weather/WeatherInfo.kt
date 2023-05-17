package com.example.weatherapp.domain.weather

import com.example.weatherapp.domain.models.WeatherData

data class WeatherInfo(
    val dayWeather: Map<Int, List<WeatherData>>,
    val currentWeather: WeatherData?
)