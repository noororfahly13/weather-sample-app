package come.example.weathersample.home.presentation

import androidx.lifecycle.ViewModel
import come.example.weathersample.home.domain.usecases.HomeUseCases


class HomeViewModel(
    private val homeUseCases: HomeUseCases,
) : ViewModel() {

}