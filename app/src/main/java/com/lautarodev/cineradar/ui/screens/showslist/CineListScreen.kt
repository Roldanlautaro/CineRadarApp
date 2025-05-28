package com.lautarodev.cineradar.ui.screens.showslist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.lautarodev.cineradar.ui.screens.Screens
import com.lautarodev.cineradar.ui.screens.commons.CineRadarUIList
import com.lautarodev.cineradar.ui.theme.CineRadarTheme
import kotlin.math.sin

@Composable
fun CineListScreen(
    modifier: Modifier = Modifier,
    viewModel: ShowsListScreenViewModel = viewModel(),
    navController: NavHostController
)
{
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

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = viewModel.uiState.searchQuery,
                modifier = Modifier.weight(1f),
                label = { Text("Buscar")},
                singleLine = true,
                onValueChange = { viewModel.searchChange(it) }
            )
            Spacer(modifier = modifier.height(12.dp))
            Button(
                onClick = { viewModel.fechtShows() }
            ) {
                Text("Buscar")
            }
        }

        Spacer(modifier = modifier.height(12.dp))
        CineRadarUIList(viewModel.uiState.showsList, modifier.fillMaxSize(), onClick = {
            id -> navController.navigate(Screens.ShowsDetail.route + "/${id}")
        })
    }
}