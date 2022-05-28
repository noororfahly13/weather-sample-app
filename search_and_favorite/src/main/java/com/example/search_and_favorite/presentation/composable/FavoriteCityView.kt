package com.example.search_and_favorite.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalUnitApi::class)
@Composable
fun FavoriteCityView(name: String, onDeleteClick: () -> Unit, onViewClick: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp)) {
        Text(
            text = name, fontSize = TextUnit(16F, TextUnitType.Sp),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable {
                onViewClick.invoke()
            }
        )
        Icon(Icons.Default.Delete, "remove favorite", modifier = Modifier.clickable {
            onDeleteClick.invoke()
        })

    }
}