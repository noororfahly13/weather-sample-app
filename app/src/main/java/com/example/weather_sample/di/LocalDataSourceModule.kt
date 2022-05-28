package com.example.weather_sample.di

import com.example.weather_sample.home.data.data_source.HomeLocalDataSource
import com.example.weather_sample.home.data.data_source.HomeLocalDataSourceImpl
import org.koin.dsl.module

val localSataSourceModule = module {
    single<HomeLocalDataSource> { HomeLocalDataSourceImpl(get()) }
}