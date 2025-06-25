package com.lautarodev.cineradar.ui.screens.perfil

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.lautarodev.cineradar.domain.IShowsRepository
import com.lautarodev.cineradar.shows.ShowsRepository
import com.lautarodev.cineradar.shows.UsuarioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PerfilScreenViewModel(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance(),
    private val showsRepository: IShowsRepository = ShowsRepository(),
    private val usuarioRepository: UsuarioRepository = UsuarioRepository() // agrega repo para vistos
) : ViewModel() {

    private val _uiState = MutableStateFlow(PerfilScreenState())
    val uiState: StateFlow<PerfilScreenState> = _uiState

    init {
        loadUserData()
        cargarVistos()
    }

    private fun loadUserData() {
        val currentUser = auth.currentUser
        if (currentUser == null) {
            _uiState.value = PerfilScreenState(errorMessage = "Usuario no logueado")
            return
        }
        _uiState.value = PerfilScreenState(
            userName = currentUser.displayName ?: "Usuario",
            userPhotoUrl = currentUser.photoUrl?.toString(),
            isLoading = false
        )
    }

    fun cargarVistos() {
        viewModelScope.launch {

            val vistosIds = usuarioRepository.getVistos()
            val vistosShows = vistosIds.map { id -> showsRepository.fetchShow(id) }
            _uiState.value = _uiState.value.copy(vistos = vistosShows)

        }
    }

    fun toggleVisto(id: String) {
        viewModelScope.launch {
            val vistosActuales = _uiState.value.vistos.toMutableList()
            val index = vistosActuales.indexOfFirst { it.id == id }

            if (index >= 0) {
                // Si ya está en vistos, removerlo
                usuarioRepository.removeVisto(id)
                vistosActuales.removeAt(index)
            } else {
                // Si no está, agregarlo
                val show = showsRepository.fetchShow(id)
                usuarioRepository.addVisto(id)
                vistosActuales.add(show)
            }
            _uiState.value = _uiState.value.copy(vistos = vistosActuales)
        }
    }
}