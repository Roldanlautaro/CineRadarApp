package com.lautarodev.cineradar.ui.screens.showslist

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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

    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_semibold)
    )

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
                text = "👀 RECOMENDACIONES",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFontFamily
            )
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
