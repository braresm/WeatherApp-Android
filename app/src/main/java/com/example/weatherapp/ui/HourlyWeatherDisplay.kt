package com.example.weatherapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.domain.models.WeatherData
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData,
    modifier: Modifier = Modifier
) {
    val localDateTime: LocalDateTime = LocalDateTime.parse(weatherData.time.toString())
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm ")
    val output: String = formatter.format(localDateTime)
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = output,
            color = Color.White
        )
        Image(
            painter = painterResource(id = weatherData.weatherIconType.icon),
            contentDescription = null,
            modifier = Modifier
                .width(20.dp)
                .height(23.dp)
        )
        Text(
            text = " ${weatherData.temperature}°C",
            color = Color.White
        )
    }
}