package com.lautarodev.cineradar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CineRadarUIList(
    list: List<shows>,
    modifier: Modifier = Modifier
){
    CineRadarUiItem(list[0])
}