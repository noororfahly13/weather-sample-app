package com.example.weather_sample.di

import com.example.weather_sample.home.data.repository.HomeRepositoryImpl
import com.example.weather_sample.home.domain.repository.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
}
