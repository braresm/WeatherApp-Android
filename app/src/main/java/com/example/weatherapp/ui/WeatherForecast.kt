package com.example.weatherapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weatherapp.ui.view.WeatherState

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    //LazyColumn(){
    //    item {
            val todayWeatherData = state.weatherInfo?.dayWeather?.get(0)
            if (todayWeatherData != null) {
                DailyWeatherDisplay(
                    dayDisplayName = "Today",
                    weatherData = todayWeatherData,
                    modifier = modifier
                )
            }
            val tommorowWeatherData = state.weatherInfo?.dayWeather?.get(1)
            if (tommorowWeatherData != null) {
                DailyWeatherDisplay(
                    dayDisplayName = "Tommorow",
                    weatherData = tommorowWeatherData,
                    modifier = modifier
                )
            }
            val afterTommorowWeatherData = state.weatherInfo?.dayWeather?.get(2)
            if (afterTommorowWeatherData != null) {
                DailyWeatherDisplay(
                    dayDisplayName = "After Tommorow",
                    weatherData = afterTommorowWeatherData,
                    modifier = modifier
                )
            }
   //     }
   // }

}
