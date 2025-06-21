package com.lautarodev.cineradar.ui.screens.showslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun CineListScreen(
    modifier: Modifier = Modifier,
    viewModel: ShowsListScreenViewModel = viewModel(),
    navController: NavHostController
) {
    val poppinsFontFamily = FontFamily(Font(R.font.poppins_semibold))

    Scaffold(
        bottomBar = {
            Navbar(navController = navController)
        },
        containerColor = Color.Black
    ) { innerPadding ->

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
                        list = viewModel.uiState.cienciaFiccion,
                        title = "\uD83D\uDCA1 RECOMENDACIONES",
                        onClick = { id -> navController.navigate(Screens.ShowsDetail.route + "/$id") }
                    )
                }

                item {
                    CineRadarUIList(
                        list = viewModel.uiState.netflixTop,
                        iconRes = R.drawable.netflix_icon,
                        title = "MEJORES PELICULAS \uD83C\uDFC6",
                        onClick = { id -> navController.navigate(Screens.ShowsDetail.route + "/$id") }
                    )
                }

                item {
                    CineRadarUIList(
                        list = viewModel.uiState.disneyScifi,
                        iconRes = R.drawable.disney_icon,
                        title = "MEJORES DE CIENCIA FICCION \uD83D\uDCAB",
                        onClick = { id -> navController.navigate(Screens.ShowsDetail.route + "/$id") }
                    )
                }

                item {
                    CineRadarUIList(
                        list = viewModel.uiState.hboHorror,
                        iconRes = R.drawable.hbo_icon,
                        title = "MEJORES PELICULAS DE TERROR \uD83D\uDC7B",
                        onClick = { id -> navController.navigate(Screens.ShowsDetail.route + "/$id") }
                    )
                }
            }
        }
    }
}