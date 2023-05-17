package com.example.weatherapp.domain.models

import com.example.weatherapp.domain.util.WeatherIconType
import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val temperature: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    var weatherIconType: WeatherIconType
)
