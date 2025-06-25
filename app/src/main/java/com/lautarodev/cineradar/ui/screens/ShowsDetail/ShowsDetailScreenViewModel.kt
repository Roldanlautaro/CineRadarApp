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
import android.util.Log
import com.lautarodev.cineradar.shows.UsuarioRepository

class ShowsDetailScreenViewModel (
    private val ShowsRepository: IShowsRepository = ShowsRepository() ,
    private var usuarioRepository: UsuarioRepository = UsuarioRepository()

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


    fun cargarGuardados(){
        viewModelScope.launch {
            val guardados = usuarioRepository.getSaved()
            uiState = uiState.copy(guardadosIds = guardados)
        }
    }

    fun guardados(id: String){
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            usuarioRepository.addSaved(id)
        }
    }

    fun toggleGuardados(id: String){
        viewModelScope.launch {
            val guardadosActuales = uiState.guardadosIds.toMutableList()
            val isSaved = guardadosActuales.contains(id)

            if (isSaved){
                usuarioRepository.removeSaved(id)
                guardadosActuales.remove(id)
            }else{
                usuarioRepository.addSaved(id)
                guardadosActuales.add(id)
            }

            // Actualizamos el estado para que Compose se entere del cambio
            uiState = uiState.copy(guardadosIds = guardadosActuales)
        }
    }


    fun cargarVistos(){
        viewModelScope.launch {
            val vistos = usuarioRepository.getVistos()
            uiState = uiState.copy(vistosIds = vistos)
        }
    }

    fun Vistos(id: String){
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            usuarioRepository.addVisto(id)
        }
    }


    fun toggleVistos(id: String) {
        viewModelScope.launch {
            val vistosActuales = uiState.vistosIds.toMutableList()
            val isVisto = vistosActuales.contains(id)

            if (isVisto) {
                usuarioRepository.removeVisto(id)
                vistosActuales.remove(id)
            } else {
                usuarioRepository.addVisto(id)
                vistosActuales.add(id)
            }

            uiState = uiState.copy(vistosIds = vistosActuales)
        }
    }
}