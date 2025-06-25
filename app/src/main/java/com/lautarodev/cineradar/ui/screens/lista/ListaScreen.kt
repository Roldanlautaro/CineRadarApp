package com.lautarodev.cineradar.ui.screens.lista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.lautarodev.cineradar.R
import com.lautarodev.cineradar.shows.shows
import com.lautarodev.cineradar.ui.screens.Screens
import com.lautarodev.cineradar.ui.screens.commons.Navbar

@Composable
fun ListaScreen(
    navController: NavHostController,
    viewModel: ListaScreenViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    // Se recarga la lista cada vez que entras o recompones la pantalla
    LaunchedEffect(Unit) {
        viewModel.cargarGuardados()
    }

    Scaffold(
        bottomBar = { Navbar(navController = navController) },
        containerColor = Color.Black
    ) { innerPadding ->

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

            Spacer(modifier = Modifier.height(16.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.lista_icon),
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "TU LISTA (${state.listaShows.size})",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(state.listaShows) { show ->
                    ShowCard(
                        show = show,
                        onClick = {
                            navController.navigate(Screens.ShowsDetail.route + "/${show.id}")
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun ShowCard(
    show: shows,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(Color(0xFF1C1C1C), shape = MaterialTheme.shapes.medium)
            .padding(16.dp)
    ) {
        AsyncImage(
            model = show.imageSet.verticalPoster.w360,
            contentDescription = "Poster de ${show.title}",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = show.title,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.imdb_icon),
                contentDescription = null,
                tint = Color.Yellow,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = show.rating.toString(),
                color = Color.White,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = show.overview.take(180) + "...",
            color = Color.Gray,
            fontSize = 13.sp
        )
    }
}
