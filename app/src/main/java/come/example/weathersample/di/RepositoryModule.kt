package come.example.weathersample.di

import come.example.weathersample.home.data.repository.HomeRepositoryImpl
import come.example.weathersample.home.domain.repository.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get(), get()) }
}
