package com.lautarodev.cineradar.ui.screens.lista

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lautarodev.cineradar.domain.IShowsRepository
import com.lautarodev.cineradar.shows.ShowsRepository
import com.lautarodev.cineradar.shows.UsuarioRepository
import com.lautarodev.cineradar.shows.shows
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class ListaScreenViewModel(
    private val repository: IShowsRepository = ShowsRepository(),
    private val usuarioRepository: UsuarioRepository = UsuarioRepository()
) : ViewModel() {

    var uiState = MutableStateFlow(ListaScreenState())
        private set

    private var fetchJob: Job? = null

    fun cargarGuardados() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val guardados = usuarioRepository.getSaved()
                val showGuardados: List<shows> = guardados.map { id ->
                    repository.fetchShow(id)
                }
                uiState.value = uiState.value.copy(listaShows = showGuardados)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
