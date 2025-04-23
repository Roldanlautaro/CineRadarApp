package com.lautarodev.cineradar

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lautarodev.cineradar.ui.theme.CineRadarTheme

@Composable
fun CineListScreen(CineRadarList : List<CineRadarResult>, modifier: Modifier = Modifier) {
    Text(
        text = "Hello Mundo",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun CineListPreview() {
    CineRadarTheme {
        CineListScreen(List<CineRadarResult>())
    }
}