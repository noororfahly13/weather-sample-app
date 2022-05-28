package come.example.weathersample.home.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import come.example.weathersample.home.data.entity.WeatherEntity

@Dao
interface HomeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weatherEntity: WeatherEntity)

    @Query("SELECT * FROM WeatherEntity LIMIT 1")
    suspend fun getWeather(): WeatherEntity

}
