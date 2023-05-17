package com.example.weatherapp.data.repository

import com.example.weatherapp.domain.util.Response
import com.example.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(latitude: Double, longitude: Double): Response<WeatherInfo>
}