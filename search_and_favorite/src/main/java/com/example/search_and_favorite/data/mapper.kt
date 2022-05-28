package com.example.search_and_favorite.data

import com.example.search_and_favorite.data.entity.CityWeatherEntity
import com.example.search_and_favorite.data.entity.FavoriteCityEntity
import com.example.search_and_favorite.data.entity.MainWeatherEntity
import com.example.search_and_favorite.data.entity.WeatherDetailsEntity
import com.example.search_and_favorite.domain.model.CityWeather
import com.example.search_and_favorite.domain.model.FavoriteCity
import com.example.search_and_favorite.domain.model.MainWeather
import com.example.search_and_favorite.domain.model.WeatherDetails

fun FavoriteCity.toEntity() = FavoriteCityEntity(name)
fun MainWeather.toEntity() = MainWeatherEntity(temp, humidity)
fun WeatherDetails.toEntity() = WeatherDetailsEntity(description, icon, id, main)
fun CityWeather.toEntity() = CityWeatherEntity(name, main?.toEntity(), weather?.map { it -> it.toEntity() })


fun FavoriteCityEntity.toModel() = FavoriteCity(name)
fun MainWeatherEntity.toModel() = MainWeather(temp, humidity)
fun WeatherDetailsEntity.toModel() = WeatherDetails(description, icon, id, main)
fun CityWeatherEntity.toModel() = CityWeather(name, main?.toModel(), weather?.map { it -> it.toModel() })
