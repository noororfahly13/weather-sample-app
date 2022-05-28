package come.example.searchandfavorite.domain.model

data class CityWeather(
    val name: String?,
    val main: MainWeather?,
    val weather: List<WeatherDetails>?,
) {
    override fun equals(other: Any?): Boolean {
        return if (other is CityWeather)
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

data class MainWeather(
    val temp: Double?,
    val humidity: Double?,
)

data class WeatherDetails(
    val description: String?,
    val icon: String?,
    val id: Int?,
    val main: String?
)