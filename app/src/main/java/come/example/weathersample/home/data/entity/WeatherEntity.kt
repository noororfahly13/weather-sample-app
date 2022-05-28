package come.example.weathersample.home.data.entity

import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(primaryKeys = ["lat", "lng"])
data class WeatherEntity(
    @Json(name = "city")
    var city: List<CityEntity>?,
    @Json(name = "lat")
    val lat: Double,
    @Json(name = "lon")
    val lng: Double,
    @Json(name = "current")
    val current: CurrentWeatherEntity?,
    @Json(name = "daily")
    val daily: List<DailyWeatherEntity>?,
) {
    override fun equals(other: Any?): Boolean {
        return if (other is WeatherEntity)
            other.lat == this.lat && other.lng == this.lng
        else false
    }

    override fun hashCode(): Int {
        var result = city?.hashCode() ?: 0
        result = 31 * result + lat.hashCode()
        result = 31 * result + lng.hashCode()
        result = 31 * result + (current?.hashCode() ?: 0)
        return result
    }

}

@JsonClass(generateAdapter = true)
@Entity(primaryKeys = ["id"])
data class WeatherDetailsEntity(
    @Json(name = "description")
    val description: String?,
    @Json(name = "icon")
    val icon: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "main")
    val main: String?
)

@JsonClass(generateAdapter = true)
@Entity(primaryKeys = ["id"])
data class CurrentWeatherEntity(
    @Json(name = "temp")
    val temp: Double?,
    @Json(name = "humidity")
    val humidity: Double?,
    @Json(name = "wind_speed")
    val windSpeed: Double?,
    @Json(name = "weather")
    val weather: List<WeatherDetailsEntity>?,
)