package come.example.weathersample.di

import come.example.weathersample.home.domain.usecases.GetCurrentLocationWeather
import org.koin.dsl.module

val useCaseModule = module {
    single { GetCurrentLocationWeather(get()) }
}