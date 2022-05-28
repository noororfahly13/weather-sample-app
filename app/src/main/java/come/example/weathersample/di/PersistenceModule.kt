package come.example.weathersample.di

import androidx.room.Room
import com.squareup.moshi.Moshi
import come.example.weathersample.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(), AppDatabase::class.java,
            "WeatherDB"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        Moshi.Builder().build()
    }


    single { get<AppDatabase>().homeDao() }
    single { get<AppDatabase>().searchAndFavoriteDao() }

}