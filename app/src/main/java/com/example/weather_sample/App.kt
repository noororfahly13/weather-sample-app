package com.example.weather_sample

import android.app.Application
import com.example.search_and_favorite.di.searchAndFavoriteModule
import com.example.weather_sample.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    persistenceModule,
                    remoteDataSourceModule,
                    localSataSourceModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                    serviceModule,
                    searchAndFavoriteModule
                )
            )
        }

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

    }

}