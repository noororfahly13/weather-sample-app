package com.example.weather_sample.di

import com.example.weather_sample.home.domain.usecases.GetCurrentLocationWeather
import com.example.weather_sample.home.domain.usecases.HomeUseCases
import org.koin.dsl.module

val useCaseModule = module {
    single { GetCurrentLocationWeather(get()) }
    single { HomeUseCases(get()) }
}