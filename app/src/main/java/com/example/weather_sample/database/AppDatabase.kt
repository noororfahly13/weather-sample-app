package com.example.weather_sample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.search_and_favorite.data.db.SearchAndFavoriteDao
import com.example.search_and_favorite.data.entity.FavoriteCityEntity
import com.example.weather_sample.home.data.db.HomeDao
import com.example.weather_sample.home.data.entity.WeatherEntity

@Database(
    entities = [WeatherEntity::class, FavoriteCityEntity::class],
    version = 8,
    exportSchema = false
)
@TypeConverters(value = [Convertors::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun homeDao(): HomeDao
    abstract fun searchAndFavoriteDao(): SearchAndFavoriteDao

}