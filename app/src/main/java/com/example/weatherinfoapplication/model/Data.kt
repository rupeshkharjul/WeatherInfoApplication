package com.example.weatherinfoapplication.model


data class Data(
    val lat : Double,
    val log : Double,
    val daily: List<Daily>
)
data class Daily(
    val dt: Long,
    val sunrise: Double,
    val sunset: Double,
    val moonrise: Double,
    val moonset: Double,
    val pressure: Double,
    val humidity: Double,
    val wind_speed: Double,
    val uvi: Double,
    val weather: List<Weather>,
    val feels_like : FeelsLike,
    val temp : Temp
)

data class Weather(
    val id: Long,
    val main: String,
    val description: String
)

data class FeelsLike(
    val day: Float,
    val night: Float,
    val eve: Float,
    val morn: Float
)

data class Temp(
    val day: Float,
    val night: Float,
    val eve: Float,
    val morn: Float,
    val min: Float,
    val max: Float
)