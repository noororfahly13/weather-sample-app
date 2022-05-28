package come.example.weathersample

import android.app.Application
import come.example.searchandfavorite.di.searchAndFavoriteModule
import come.example.weathersample.di.*
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