package com.lautarodev.cineradar.ui.screens.perfil

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.lautarodev.cineradar.domain.IShowsRepository
import com.lautarodev.cineradar.shows.ShowsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PerfilScreenViewModel(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance(),
    private val showsRepository: IShowsRepository = ShowsRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(PerfilScreenState())
    val uiState: StateFlow<PerfilScreenState> = _uiState

    init {
        loadUserData()
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

    fun logout(onLoggedOut: () -> Unit) {
        auth.signOut()
        onLoggedOut()
    }
}
