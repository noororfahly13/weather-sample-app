package come.example.searchandfavorite.data

import come.example.searchandfavorite.data.entity.CityWeatherEntity
import come.example.searchandfavorite.data.entity.FavoriteCityEntity
import come.example.searchandfavorite.data.entity.MainWeatherEntity
import come.example.searchandfavorite.data.entity.WeatherDetailsEntity
import come.example.searchandfavorite.domain.model.CityWeather
import come.example.searchandfavorite.domain.model.FavoriteCity
import come.example.searchandfavorite.domain.model.MainWeather
import come.example.searchandfavorite.domain.model.WeatherDetails

fun FavoriteCity.toEntity() = FavoriteCityEntity(name)
fun MainWeather.toEntity() = MainWeatherEntity(temp, humidity)
fun WeatherDetails.toEntity() = WeatherDetailsEntity(description, icon, id, main)
fun CityWeather.toEntity() = CityWeatherEntity(name, main?.toEntity(), weather?.map { it -> it.toEntity() })


fun FavoriteCityEntity.toModel() = FavoriteCity(name)
fun MainWeatherEntity.toModel() = MainWeather(temp, humidity)
fun WeatherDetailsEntity.toModel() = WeatherDetails(description, icon, id, main)
fun CityWeatherEntity.toModel() = CityWeather(name, main?.toModel(), weather?.map { it -> it.toModel() })
