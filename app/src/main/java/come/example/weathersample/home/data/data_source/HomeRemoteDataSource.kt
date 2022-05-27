package come.example.weathersample.home.data.data_source

import come.example.weathersample.home.data.api.HomeService


interface HomeRemoteDataSource {
}

class HomeRemoteDataSourceImpl(
    private val homeService: HomeService
) : HomeRemoteDataSource {
}