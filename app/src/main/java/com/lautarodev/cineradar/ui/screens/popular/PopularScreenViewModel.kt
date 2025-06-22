package com.lautarodev.cineradar.ui.screens.popular

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
import java.io.IOException

class PopularScreenViewModel (
    private val ShowsRepository : IShowsRepository = ShowsRepository()
) : ViewModel()

{
    var uiState by mutableStateOf(PopularScreenState())
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
                val mejoresSeries = ShowsRepository.getMejoresSeries()
                val mejoresPeliculasDelAnio = ShowsRepository.getMejoresPeliculasDelAnio()
                val mejoresSeriesDeLosUltimosAnios = ShowsRepository.getMejoresSeriesDeLosUltimosAnios()
                val mejoresPeliculas = ShowsRepository.getMejoresPeliculas()

                uiState = uiState.copy(
                    mejoresSeries = mejoresSeries,
                    mejoresPeliculasDelAnio = mejoresPeliculasDelAnio,
                    mejoresSeriesDeLosUltimosAnios = mejoresSeriesDeLosUltimosAnios,
                    mejoresPeliculas = mejoresPeliculas,
                    isLoading = false // Ocultar loader
                )

            } catch (e: IOException) {
                Log.e("CineRadar", "Error recuperando los datos", e)
            }
        }
    }
}