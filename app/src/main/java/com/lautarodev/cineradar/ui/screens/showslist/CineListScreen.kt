package com.lautarodev.cineradar.ui.screens.showslist

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.lautarodev.cineradar.ui.screens.Screens
import com.lautarodev.cineradar.ui.screens.commons.CineRadarUIList
import com.lautarodev.cineradar.ui.screens.commons.Navbar

@Composable
fun CineListScreen(
    modifier: Modifier = Modifier,
    viewModel: ShowsListScreenViewModel = viewModel(),
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
                text = "Lista de películas",
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
