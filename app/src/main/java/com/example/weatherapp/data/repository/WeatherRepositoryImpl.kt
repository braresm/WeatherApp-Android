package com.example.weatherapp.data.repository

import android.location.Address
import android.location.Geocoder
import androidx.compose.ui.text.intl.Locale
import com.example.weatherapp.data.api.WeatherApi
import com.example.weatherapp.data.mappers.toWeatherInfo
import com.example.weatherapp.domain.util.Response
import com.example.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject


class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): Response<WeatherInfo> {

        return try {
            Response.Success(
                data = weatherApi.getWeather(
                    latitude = latitude,
                    longitude = longitude
                ).toWeatherInfo()
            )
        } catch(ex: Exception) {
            ex.printStackTrace()
            Response.Error(ex.message ?: "An error occurred while getting the weather data.")
        }

    }
}