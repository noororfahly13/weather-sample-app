package come.example.weathersample.home.domain.usecases

import come.example.weathersample.home.domain.repository.HomeRepository


class GetCurrentLocationWeather(private val repository: HomeRepository) {
    operator fun invoke(movieID: Int) = repository.toString()
}