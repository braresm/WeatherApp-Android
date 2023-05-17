package com.example.weatherapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.view.WeatherState
import com.example.weatherapp.R
import com.example.weatherapp.data.location.LocationTracker

@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeather?.let { data ->
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(16.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Your location",
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = data.weatherIconType.icon),
                    contentDescription = null,
                    modifier = Modifier.width(200.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${data.temperature}°C",
                    fontSize = 48.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = data.weatherIconType.description,
                    fontSize = 26.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherItem(
                        value = data.humidity, unit = "%", icon = ImageVector.vectorResource(
                            id = R.drawable.ic_drop,
                        ), textStyle = TextStyle(color = Color.White)
                    )
                    WeatherItem(
                        value = data.pressure, unit = "hpa", icon = ImageVector.vectorResource(
                            id = R.drawable.ic_pressure,
                        ), textStyle = TextStyle(color = Color.White)
                    )
                    WeatherItem(
                        value = data.windSpeed, unit = "km/h", icon = ImageVector.vectorResource(
                            id = R.drawable.ic_wind,
                        ), textStyle = TextStyle(color = Color.White)
                    )
                }
            }
        }
    }
}