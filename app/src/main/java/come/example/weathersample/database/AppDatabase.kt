package come.example.weathersample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import come.example.weathersample.home.data.db.HomeDao
import come.example.weathersample.home.data.entity.WeatherEntity

@Database(
    entities = [WeatherEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun homeDao(): HomeDao
}