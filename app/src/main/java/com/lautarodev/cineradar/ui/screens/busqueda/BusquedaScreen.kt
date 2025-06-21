package com.lautarodev.cineradar.ui.screens.busqueda

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.lautarodev.cineradar.R
import com.lautarodev.cineradar.ui.screens.Screens
import com.lautarodev.cineradar.ui.screens.commons.CineRadarUIList
import com.lautarodev.cineradar.ui.screens.commons.Navbar
import kotlinx.coroutines.delay

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

            // Estado local para búsqueda con debounce
            var searchQuery by remember { mutableStateOf(viewModel.uiState.searchQuery) }

            // Cuando cambia searchQuery, esperamos 500ms y luego lanzamos búsqueda
            LaunchedEffect(searchQuery) {
                delay(500)
                viewModel.searchChange(searchQuery)
                viewModel.fechtShows()
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier.fillMaxWidth(0.9f),
                    placeholder = { Text("Buscar...", color = Color.Gray) },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Ícono de buscar",
                            tint = Color.White
                        )
                    },
                    shape = RoundedCornerShape(12.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            CineRadarUIList(
                list = viewModel.uiState.showsList,
                title = "",
                modifier = Modifier.fillMaxSize(),
                onClick = { id ->
                    navController.navigate(Screens.ShowsDetail.route + "/$id")
                }
            )
        }
    }
}
