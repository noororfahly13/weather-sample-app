package come.example.weathersample.home.data.data_source

import come.example.weathersample.home.data.db.HomeDao


interface HomeLocalDataSource {
}

class HomeLocalDataSourceImpl(private val homeDao: HomeDao) : HomeLocalDataSource {

}