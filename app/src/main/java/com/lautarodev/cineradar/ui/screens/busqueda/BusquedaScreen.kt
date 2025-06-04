package com.lautarodev.cineradar.ui.screens.busqueda

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.lautarodev.cineradar.ui.screens.Screens
import com.lautarodev.cineradar.ui.screens.commons.CineRadarUIList
import com.lautarodev.cineradar.ui.screens.commons.Navbar
import com.lautarodev.cineradar.ui.screens.showslist.ShowsListScreenViewModel

@Composable
fun BusquedaScreen(
    modifier: Modifier = Modifier,
    viewModel: BusquedaScreenViewModel = viewModel(),
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            Navbar(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Buscar Peliculas e Series",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = viewModel.uiState.searchQuery,
                    modifier = Modifier.weight(1f),
                    label = { Text("Buscar") },
                    singleLine = true,
                    onValueChange = { viewModel.searchChange(it) }
                )
                Spacer(modifier = Modifier.width(12.dp))
                Button(onClick = { viewModel.fechtShows() }) {
                    Text("Buscar")
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            CineRadarUIList(
                viewModel.uiState.showsList,
                modifier = Modifier.fillMaxSize(),
                onClick = { id ->
                    navController.navigate(Screens.ShowsDetail.route + "/$id")
                }
            )
        }
    }
}