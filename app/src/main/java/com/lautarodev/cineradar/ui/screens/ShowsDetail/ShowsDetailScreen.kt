package com.lautarodev.cineradar.ui.screens.ShowsDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.compose.runtime.LaunchedEffect
import com.lautarodev.cineradar.shows.shows


@Composable
fun ShowsDetailScreen(
    id: String,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ShowsDetailScreenViewModel = viewModel()
) {
    LaunchedEffect(id) {
        viewModel.setShowsID(id)
        viewModel.cargarGuardados()
        viewModel.cargarVistos()
    }

    val show = viewModel.uiState.ShowsDetail
    val isSaved = viewModel.uiState.guardadosIds.contains(id)
    val isVisto = viewModel.uiState.vistosIds.contains(id)

    if (show.id.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        ShowsUiItemDetail(
            shows = show,
            navController = navController,
            isSaved = isSaved,
            isVisto = isVisto,
            onSaveClick = { viewModel.toggleGuardados(id) },
            onVistoClick = { viewModel.toggleVistos(id) }
        )
    }
}
