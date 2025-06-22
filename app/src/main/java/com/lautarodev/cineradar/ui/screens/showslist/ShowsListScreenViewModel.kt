package com.lautarodev.cineradar.ui.screens.showslist


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lautarodev.cineradar.domain.IShowsRepository
import com.lautarodev.cineradar.shows.ShowsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okio.IOException

class ShowsListScreenViewModel(
    private val ShowsRepository : IShowsRepository = ShowsRepository()
) : ViewModel()

{
    var uiState by mutableStateOf(ShowsListScreenState())
        private set

    init {
        fechtShows() // Muestra los datos
    }

    private var fetchJob : Job? = null

    fun fechtShows() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            uiState = uiState.copy(isLoading = true) // Mostrar loader

            try {
                val cienciaFiccion = ShowsRepository.getAllCienciaFiccion()
                val netflixTop = ShowsRepository.getAllMejoresPeliculasNETFLIX()
                val disneyScifi = ShowsRepository.getAllMejoresPeliculasCienciaFiccionDISNEY()
                val hboHorror = ShowsRepository.getAllMejoresPeliculasTerrorHBO()

                uiState = uiState.copy(
                    cienciaFiccion = cienciaFiccion,
                    netflixTop = netflixTop,
                    disneyScifi = disneyScifi,
                    hboHorror = hboHorror,
                    isLoading = false // Ocultar loader
                )

            } catch (e: IOException) {
                Log.e("CineRadar", "Error recuperando los datos", e)
                uiState = uiState.copy(isLoading = false) // Asegurarse de ocultar el loader aunque falle
            }
        }
    }
}
