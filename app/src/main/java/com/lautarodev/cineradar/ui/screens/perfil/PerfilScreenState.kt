package com.lautarodev.cineradar.ui.screens.perfil

import com.lautarodev.cineradar.shows.shows

data class PerfilScreenState(
    val userName: String = "",
    val userPhotoUrl: String? = null,
    val vistos: List<shows> = emptyList(),
    val vistosIds : List<String> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)
