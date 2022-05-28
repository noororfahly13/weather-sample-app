package com.example.search_and_favorite.presentation.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.core.common_ui.CenteredView
import com.example.core.navigation.Screen
import com.example.search_and_favorite.R
import com.example.search_and_favorite.presentation.composable.FavoriteCityView
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun FavoriteScreen(
    navController: NavHostController,
    viewModel: FavoriteViewModel = getViewModel(),
) {
    val systemUiController = rememberSystemUiController()
    val scaffoldState = rememberScaffoldState()
    val favoriteScreenState by viewModel.favoritesState.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState,
        snackbarHost = { scaffoldState.snackbarHostState },
        topBar = {

        },
        content = {
            Column(Modifier.padding(horizontal = 32.dp)) {
                Spacer(modifier = Modifier.height(64.dp))
                Text(
                    text = stringResource(id = R.string.favorite_cities),
                    fontSize = TextUnit(20F, TextUnitType.Sp),
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                when (favoriteScreenState) {
                    is FavoriteScreenState.Data ->
                        LazyColumn() {
                            items((favoriteScreenState as FavoriteScreenState.Data).favorites) {
                                FavoriteCityView(it.name, { viewModel.removeFavoriteCity(it) }) {
                                    navController.navigate(Screen.City.passName(it.name))
                                }
                            }
                        }
                    is FavoriteScreenState.Error -> CenteredView {
                        Text("Error")
                    }
                    FavoriteScreenState.Idle, FavoriteScreenState.Loading -> CenteredView {
                        CircularProgressIndicator()
                    }
                }
            }
        }
    )
}