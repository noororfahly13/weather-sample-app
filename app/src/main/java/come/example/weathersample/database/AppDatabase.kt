package come.example.weathersample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import come.example.weathersample.home.data.db.HomeDao
import come.example.weathersample.home.data.entity.WeatherEntity

@Database(
    entities = [WeatherEntity::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(value = [Convertors::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun homeDao(): HomeDao
}