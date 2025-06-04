package com.lautarodev.cineradar.ui.screens.commons

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import com.lautarodev.cineradar.shows.shows

@Composable
fun CineRadarUIList(
    list: List<shows>,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
){
    LazyColumn(
        modifier = modifier
    ){
        items(
            items = list,
            key = { it -> it.id}
        ){
            shows -> CineRadarUiItem(shows, onClick= onClick)
        }
    }
}