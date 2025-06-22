package com.lautarodev.cineradar.ui.screens.ShowsDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.lautarodev.cineradar.ui.screens.commons.CineRadarUiItem

@Composable
fun ShowsDetailScreen(
    id: String,
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ShowsDetailScreenViewModel = viewModel()
) {
    viewModel.setShowsID(id)

    if (viewModel.uiState.ShowsDetail.id.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

    } else {
        ShowsUiItemDetail(viewModel.uiState.ShowsDetail, navController)
    }
}