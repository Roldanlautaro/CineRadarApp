package com.lautarodev.cineradar.ui.screens.showslist

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
import com.lautarodev.cineradar.ui.screens.commons.CineRadarRecommendations
import com.lautarodev.cineradar.ui.screens.commons.CineRadarUIList
import com.lautarodev.cineradar.ui.screens.commons.Navbar

@Composable
fun CineListScreen(
    modifier: Modifier = Modifier,
    viewModel: ShowsListScreenViewModel = viewModel(),
    navController: NavHostController
) {
    val state = viewModel.uiState

    Scaffold(
        bottomBar = { Navbar(navController = navController) },
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
            // Contenido de la pantalla
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color.Black)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cineradar_logo),
                        contentDescription = "Logo CineRadar",
                        modifier = Modifier.size(36.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 80.dp)
                ) {
                    item {
                        CineRadarRecommendations(
                            list = state.cienciaFiccion,
                            onClick = { id -> navController.navigate(Screens.ShowsDetail.route + "/$id") }
                        )
                    }
                    item {
                        CineRadarUIList(
                            list = state.netflixTop,
                            iconRes = R.drawable.netflix_icon,
                            title = "MEJORES PELÍCULAS 🏆",
                            onClick = { id -> navController.navigate(Screens.ShowsDetail.route + "/$id") }
                        )
                    }
                    item {
                        CineRadarUIList(
                            list = state.disneyScifi,
                            iconRes = R.drawable.disney_icon,
                            title = "CIENCIA FICCIÓN ✨",
                            onClick = { id -> navController.navigate(Screens.ShowsDetail.route + "/$id") }
                        )
                    }
                    item {
                        CineRadarUIList(
                            list = state.hboHorror,
                            iconRes = R.drawable.hbo_icon,
                            title = "TERROR 👻",
                            onClick = { id -> navController.navigate(Screens.ShowsDetail.route + "/$id") }
                        )
                    }
                }
            }
        }
    }
}
