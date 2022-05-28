package come.example.searchandfavorite.data.entity

import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(primaryKeys = ["name"])
data class CityWeatherEntity(
    @Json(name = "name")
    val name: String?,
    @Json(name = "main")
    val main: MainWeatherEntity?,
    @Json(name = "weather")
    val weather: List<WeatherDetailsEntity>?,
) {
    override fun equals(other: Any?): Boolean {
        return if (other is CityWeatherEntity)
            other.name == this.name
        else false
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (main?.hashCode() ?: 0)
        result = 31 * result + (weather?.hashCode() ?: 0)
        return result
    }

}

@JsonClass(generateAdapter = true)
@Entity(primaryKeys = ["id"])
data class MainWeatherEntity(
    @Json(name = "temp")
    val temp: Double?,
    @Json(name = "humidity")
    val humidity: Double?,
)

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