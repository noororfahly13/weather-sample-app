package come.example.weathersample.di

import come.example.weathersample.home.domain.usecases.GetCurrentLocationWeather
import come.example.weathersample.home.domain.usecases.HomeUseCases
import org.koin.dsl.module

val useCaseModule = module {
    single { GetCurrentLocationWeather(get()) }
    single { HomeUseCases(get()) }
}