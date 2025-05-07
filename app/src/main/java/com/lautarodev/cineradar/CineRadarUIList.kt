package com.lautarodev.cineradar

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items

@Composable
fun CineRadarUIList(
    list: List<shows>,
    modifier: Modifier = Modifier
){
    // CineRadarUiItem(list[0])
    LazyColumn(
        modifier = modifier
    ){
        items(
            items = list,
            key = { it -> it.id}
        ){
            shows -> CineRadarUiItem(shows)
        }
    }
}