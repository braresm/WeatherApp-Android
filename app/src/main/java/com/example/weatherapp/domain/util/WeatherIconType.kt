package com.example.weatherapp.domain.util

import androidx.annotation.DrawableRes
import com.example.weatherapp.R

sealed class WeatherIconType(
    val description: String,
    @DrawableRes val icon: Int
) {
    object ClearSky : WeatherIconType(
        description = "Clear sky",
        icon = R.drawable.ic_sunny
    )
    object MainlyClear : WeatherIconType(
        description = "Mainly clear",
        icon = R.drawable.ic_cloudy
    )
    object PartlyCloudy : WeatherIconType(
        description = "Partly cloudy",
        icon = R.drawable.ic_cloudy
    )
    object Overcast : WeatherIconType(
        description = "Overcast",
        icon = R.drawable.ic_cloudy
    )
    object Foggy : WeatherIconType(
        description = "Foggy",
        icon = R.drawable.ic_very_cloudy
    )
    object DepositingRimeFog : WeatherIconType(
        description = "Depositing rime fog",
        icon = R.drawable.ic_very_cloudy
    )
    object LightDrizzle : WeatherIconType(
        description = "Light drizzle",
        icon = R.drawable.ic_rainshower
    )
    object ModerateDrizzle : WeatherIconType(
        description = "Moderate drizzle",
        icon = R.drawable.ic_rainshower
    )
    object DenseDrizzle : WeatherIconType(
        description = "Dense drizzle",
        icon = R.drawable.ic_rainshower
    )
    object LightFreezingDrizzle : WeatherIconType(
        description = "Slight freezing drizzle",
        icon = R.drawable.ic_snowyrainy
    )
    object DenseFreezingDrizzle : WeatherIconType(
        description = "Dense freezing drizzle",
        icon = R.drawable.ic_snowyrainy
    )
    object SlightRain : WeatherIconType(
        description = "Slight rain",
        icon = R.drawable.ic_rainy
    )
    object ModerateRain : WeatherIconType(
        description = "Rainy",
        icon = R.drawable.ic_rainy
    )
    object HeavyRain : WeatherIconType(
        description = "Heavy rain",
        icon = R.drawable.ic_rainy
    )
    object HeavyFreezingRain: WeatherIconType(
        description = "Heavy freezing rain",
        icon = R.drawable.ic_snowyrainy
    )
    object SlightSnowFall: WeatherIconType(
        description = "Slight snow fall",
        icon = R.drawable.ic_snowy
    )
    object ModerateSnowFall: WeatherIconType(
        description = "Moderate snow fall",
        icon = R.drawable.ic_heavysnow
    )
    object HeavySnowFall: WeatherIconType(
        description = "Heavy snow fall",
        icon = R.drawable.ic_heavysnow
    )
    object SnowGrains: WeatherIconType(
        description = "Snow grains",
        icon = R.drawable.ic_heavysnow
    )
    object SlightRainShowers: WeatherIconType(
        description = "Slight rain showers",
        icon = R.drawable.ic_rainshower
    )
    object ModerateRainShowers: WeatherIconType(
        description = "Moderate rain showers",
        icon = R.drawable.ic_rainshower
    )
    object ViolentRainShowers: WeatherIconType(
        description = "Violent rain showers",
        icon = R.drawable.ic_rainshower
    )
    object SlightSnowShowers: WeatherIconType(
        description = "Light snow showers",
        icon = R.drawable.ic_snowy
    )
    object HeavySnowShowers: WeatherIconType(
        description = "Heavy snow showers",
        icon = R.drawable.ic_snowy
    )
    object ModerateThunderstorm: WeatherIconType(
        description = "Moderate thunderstorm",
        icon = R.drawable.ic_thunder
    )
    object SlightHailThunderstorm: WeatherIconType(
        description = "Thunderstorm with slight hail",
        icon = R.drawable.ic_rainythunder
    )
    object HeavyHailThunderstorm: WeatherIconType(
        description = "Thunderstorm with heavy hail",
        icon = R.drawable.ic_rainythunder
    )

    companion object {
        fun getWeatherIcon(code: Int): WeatherIconType {
            return when(code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}