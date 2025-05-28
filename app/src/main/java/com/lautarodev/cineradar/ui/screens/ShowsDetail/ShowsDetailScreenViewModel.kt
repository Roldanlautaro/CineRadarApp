package com.lautarodev.cineradar.ui.screens.ShowsDetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lautarodev.cineradar.domain.IShowsRepository
import com.lautarodev.cineradar.shows.ShowsRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ShowsDetailScreenViewModel (
    private val ShowsRepository: IShowsRepository = ShowsRepository()
): ViewModel()  {
    var uiState by mutableStateOf(ShowsDetailScreenState())
        private set

    private var fetchJob: Job? = null

    fun fetchShows(){
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            val show = ShowsRepository.fetchShow(uiState.id)
            uiState = uiState.copy(ShowsDetail = show)
        }
    }

    fun setShowsID(id : String) : Unit{
        uiState = uiState.copy(id = id, ShowsDetail = uiState.ShowsDetail)
        fetchShows()
    }

}