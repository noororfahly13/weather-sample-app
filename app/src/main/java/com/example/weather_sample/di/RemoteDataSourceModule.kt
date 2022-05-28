package com.example.weather_sample.di

import com.example.weather_sample.home.data.data_source.HomeRemoteDataSource
import com.example.weather_sample.home.data.data_source.HomeRemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<HomeRemoteDataSource> { HomeRemoteDataSourceImpl(get()) }
}