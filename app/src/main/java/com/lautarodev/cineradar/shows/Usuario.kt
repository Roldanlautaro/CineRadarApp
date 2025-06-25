package com.lautarodev.cineradar.shows

data class Usuario(
    val email : String = "",
    val guardados : MutableList<String> = mutableListOf(),
    val vistos : MutableList<String> = mutableListOf()
)


