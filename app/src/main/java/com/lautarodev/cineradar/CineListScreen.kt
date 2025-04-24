package com.lautarodev.cineradar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lautarodev.cineradar.ui.theme.CineRadarTheme

@Composable
fun CineListScreen(CineRadarList: List<shows>, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize().padding(16.dp)
    )
    {
        Text(
        text = "Lista de peliculas",
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier
    )
        Spacer(modifier = modifier.height(12.dp))
        CineRadarUIList(CineRadarList, modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun CineListPreview() {
    CineRadarTheme {

        // dasdsadsa
    }
}