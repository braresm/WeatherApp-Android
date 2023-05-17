package com.example.weatherapp.data.mappers

import android.util.Log
import com.example.weatherapp.data.dto.WeatherDataDto
import com.example.weatherapp.data.dto.WeatherDto
import com.example.weatherapp.domain.util.WeatherIconType
import com.example.weatherapp.domain.weather.WeatherInfo
import com.example.weatherapp.domain.models.WeatherData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun WeatherDataDto.toDayWeatherMap(): Map<Int, List<WeatherData>> {
    /**
     * Build the day weather map.
     * The key of the map will represent the day index.
     * The value of the map will be the weather data for each hour in the corresponding day.
     */

    val dayWeatherMap = mutableMapOf<Int, List<WeatherData>>()
    var dayWeathers = mutableListOf<WeatherData>()

    times.forEachIndexed { index, time ->
        // Calculate the index of the day
        val dayIndex = index / 24;

        // Create weather data object of the current index and add it to the list
        val weatherData = WeatherData(
            time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
            temperature = temperatures[index],
            pressure = pressures[index],
            windSpeed = windSpeeds[index],
            humidity = humidities[index],
            weatherIconType = WeatherIconType.getWeatherIcon(weatherCodes[index])
        )
        dayWeathers.add(weatherData)

        // Add to the day map only weather data for all 24 hours have been created
        if((index + 1) % 24 == 0) {
            dayWeatherMap[dayIndex] = dayWeathers
            dayWeathers = mutableListOf()
        }
    }

    return dayWeatherMap
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val dayWeatherMap = weatherData.toDayWeatherMap()
    val now = LocalDateTime.now()

    // Get the weather for the current hour
    val currentWeatherData = dayWeatherMap[0]?.find {
        it.time.hour == now.hour
    }

    return WeatherInfo(
        dayWeather = dayWeatherMap,
        currentWeather = currentWeatherData
    )
}