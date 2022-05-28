package come.example.core.network.constants

object ConnectionEndPoint {

    private const val WEATHER_VERSION = "data/2.5/"
    private const val GEO_VERSION = "geo/1.0/"

    const val IMAGE = "http://openweathermap.org/img/wn/"

    const val WEATHER = WEATHER_VERSION + "weather?units=metric"

    const val ONE_CALL = WEATHER_VERSION + "onecall?exclude=minutely,hourly,alerts&units=metric"

    const val GEO_REVERSE = GEO_VERSION + "reverse?limit=3"


}