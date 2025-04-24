package com.lautarodev.cineradar

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CineRadarUiItem(
    shows: shows,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = shows.title
        )
        Text(
            text = shows.overview
        )
    }
}