package come.example.weathersample.home.data.entity

import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(primaryKeys = ["dt"])
data class DailyWeatherEntity(
    @Json(name = "dt")
    val dt: Long?,
    @Json(name = "temp")
    val temp: TempEntity?,
    @Json(name = "humidity")
    val humidity: Double?,
    @Json(name = "windSpeed")
    val windSpeed: Double?,
    @Json(name = "weather")
    val weather: List<WeatherDetailsEntity>?,
)

@JsonClass(generateAdapter = true)
@Entity(primaryKeys = ["min", "max"])
data class TempEntity(
    @Json(name = "min")
    val min: Double?,
    @Json(name = "max")
    val max: Double?,
)