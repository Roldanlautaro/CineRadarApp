package com.lautarodev.cineradar.ui.screens.showslist


import android.icu.text.StringSearch
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.lautarodev.cineradar.domain.IShowsRepository
import com.lautarodev.cineradar.shows.CineRadarResult
import com.lautarodev.cineradar.shows.ShowsRepository
import com.lautarodev.cineradar.shows.shows
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okio.IOException

class ShowsListScreenViewModel(
    private val ShowsRepository : IShowsRepository = ShowsRepository()
) : ViewModel()

{
    var uiState by mutableStateOf(ShowsListScreenState())
        private set


    private var fetchJob : Job? = null

    fun fechtShows(){

        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                uiState = uiState.copy(showsList = ShowsRepository.fetchShows(uiState.searchQuery))

            }catch (e: IOException) {
                Log.e("CineRadar","Error recuperando la lista de peliculas/series")
            }

        }
    }

    fun searchChange(search: String){
        uiState = uiState.copy(searchQuery = search, showsList = uiState.showsList)
    }
}
