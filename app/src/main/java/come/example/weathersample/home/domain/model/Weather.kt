package come.example.weathersample.home.domain.model

data class Weather(
    val city: List<City>?,
    val lat: Double,
    val lng: Double,
    val current: CurrentWeather?,
    val daily: List<DailyWeather>?
)

data class WeatherDetails(
    val description: String?,
    val icon: String?,
    val id: Int?,
    val main: String?
)

data class CurrentWeather(
    val temp: Double?,
    val humidity: Double?,
    val windSpeed: Double?,
    val weather: List<WeatherDetails>?,
)