package come.example.weathersample.home.data

import come.example.weathersample.home.data.entity.*
import come.example.weathersample.home.domain.model.*

fun WeatherEntity.toModel(): Weather = Weather(city?.map { it -> it.toModel() }, lat, lng, current?.toModel(), daily?.map { it -> it.toModel() })
fun CurrentWeatherEntity.toModel() = CurrentWeather(temp, humidity, windSpeed, weather?.map { it -> it.toModel() })
fun WeatherDetailsEntity.toModel() = WeatherDetails(description, icon, id, main)
fun CityEntity.toModel() = City(name, state, country)
fun DailyWeatherEntity.toModel() = DailyWeather(dt, temp?.toModel(), humidity, windSpeed, weather?.map { it -> it.toModel() })
fun TempEntity.toModel() = Temp(min, max)

fun Weather.toEntity() = WeatherEntity(city?.map { it -> it.toEntity() }, lat, lng, current?.toEntity(), daily?.map { it -> it.toEntity() })
fun WeatherDetails.toEntity() = WeatherDetailsEntity(description, icon, id, main)
fun CurrentWeather.toEntity() = CurrentWeatherEntity(temp, humidity, windSpeed, weather?.map { it -> it.toEntity() })
fun City.toEntity() = CityEntity(name, state, country)
fun DailyWeather.toEntity() = DailyWeatherEntity(dt, temp?.toEntity(), humidity, windSpeed, weather?.map { it -> it.toEntity() })
fun Temp.toEntity() = TempEntity(min, max)