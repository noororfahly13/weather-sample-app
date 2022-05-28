package come.example.weathersample.home.data

import come.example.weathersample.home.data.entity.CurrentWeatherEntity
import come.example.weathersample.home.data.entity.WeatherDetailsEntity
import come.example.weathersample.home.data.entity.WeatherEntity
import come.example.weathersample.home.domain.model.CurrentWeather
import come.example.weathersample.home.domain.model.Weather
import come.example.weathersample.home.domain.model.WeatherDetails

fun WeatherEntity.toModel(): Weather = Weather(id, lat, lng, current?.toModel())
fun CurrentWeatherEntity.toModel() = CurrentWeather(temp, humidity, windSpeed, weather?.map { it -> it.toModel() })
fun WeatherDetailsEntity.toModel() = WeatherDetails(description, icon, id, main)

fun Weather.toEntity() = WeatherEntity(id, lat, lng, current?.toEntity())
fun WeatherDetails.toEntity() = WeatherDetailsEntity(description, icon, id, main)
fun CurrentWeather.toEntity() = CurrentWeatherEntity(temp, humidity, windSpeed, weather?.map { it -> it.toEntity() })

