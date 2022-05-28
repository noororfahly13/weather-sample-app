package com.example.weather_sample.di

import com.example.core.network.setup.NetworkResponseFactory
import com.example.core.network.setup.RequestInterceptor
import com.example.search_and_favorite.data.api.SearchAndFavoriteService
import com.example.weather_sample.BuildConfig
import com.example.weather_sample.home.data.api.HomeService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    // provides Retrofit client
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseFactory())
            .build()
    }

    // provides OkHttpClient
    single {
        val logging = HttpLoggingInterceptor()
        logging.apply { logging.level = HttpLoggingInterceptor.Level.BODY }
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addInterceptor(logging)
            .connectTimeout(45, TimeUnit.SECONDS)
            .readTimeout(45, TimeUnit.SECONDS)
            .writeTimeout(45, TimeUnit.SECONDS)
            .build()
    }

    single { get<Retrofit>().create(HomeService::class.java) }
    single { get<Retrofit>().create(SearchAndFavoriteService::class.java) }

}
