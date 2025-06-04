package com.lautarodev.cineradar.ui.screens.busqueda

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

class BusquedaScreenViewModel(
    private val ShowsRepository : IShowsRepository = ShowsRepository()
) : ViewModel()

{
    var uiState by mutableStateOf(BusquedaScreenState())
        private set


    private var fetchJob : Job? = null

    fun fechtShows(){

        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                uiState = uiState.copy(showsList = ShowsRepository.fetchShows(uiState.searchQuery))

            }catch (e: IOException) {
                Log.e("CineRadar","Error recuperando la lista de peliculas e series")
            }

        }
    }

    fun searchChange(search: String){
        uiState = uiState.copy(searchQuery = search, showsList = uiState.showsList)
    }
}
