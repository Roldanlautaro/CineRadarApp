package com.lautarodev.cineradar.ui.screens.popular

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.lautarodev.cineradar.R
import com.lautarodev.cineradar.ui.screens.Screens
import com.lautarodev.cineradar.ui.screens.commons.CineRadarUIList
import com.lautarodev.cineradar.ui.screens.commons.Navbar

@Composable
fun PopularScreen(
    modifier: Modifier = Modifier,
    viewModel: PopularScreenViewModel = viewModel(),
    navController: NavHostController
) {
    val state = viewModel.uiState

    Scaffold(
        bottomBar = {
            Navbar(navController = navController)
        },
        containerColor = Color.Black
    ) { innerPadding ->

        if (state.isLoading) {
            // Loader mientras se cargan los datos
            AnimatedVisibility(
                visible = state.isLoading,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color(0xFFFE5196))
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color.Black)
            ) {
                // HEADER (logo arriba del todo, chiquito y centrado)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp), // casi pegado al top
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cineradar_logo),
                        contentDescription = "Logo CineRadar",
                        modifier = Modifier.size(36.dp) // más chico
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // CONTENIDO

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    item {
                        CineRadarUIList(
                            list = viewModel.uiState.mejoresSeries,
                            title = "\uD83D\uDD25 MEJORES SERIES",
                            onClick = { id -> navController.navigate(Screens.ShowsDetail.route + "/$id") }
                        )
                    }

                    item {
                        CineRadarUIList(
                            list = viewModel.uiState.mejoresPeliculasDelAnio,
                            title = "\uD83C\uDFC6 MEJOR PELICULA DE LOS ULTIMOS AÑOS",
                            onClick = { id -> navController.navigate(Screens.ShowsDetail.route + "/$id") }
                        )
                    }

                    item {
                        CineRadarUIList(
                            list = viewModel.uiState.mejoresSeriesDeLosUltimosAnios,
                            title = "\uD83C\uDF1F SERIE POPULAR DE LOS ULTIMOS AÑO",
                            onClick = { id -> navController.navigate(Screens.ShowsDetail.route + "/$id") }
                        )
                    }

                    item {
                        CineRadarUIList(
                            list = viewModel.uiState.mejoresPeliculas,
                            title = "\uD83D\uDD25 MEJOR PELICULA",
                            onClick = { id -> navController.navigate(Screens.ShowsDetail.route + "/$id") }
                        )
                    }
                }
            }
        }
    }
}
