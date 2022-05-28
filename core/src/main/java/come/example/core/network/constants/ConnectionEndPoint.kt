package come.example.core.network.constants

object ConnectionEndPoint {

    private const val VERSION = "data/2.5/"

    const val WEATHER = VERSION + "weather"

    const val ONE_CALL = VERSION + "onecall?exclude=minutely,hourly,alerts&units=metric"

}