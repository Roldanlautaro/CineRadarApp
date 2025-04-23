package com.lautarodev.cineradar

data class shows(
    val itemType : String, // Show
    val showType : String, // Movie o series
    val id : Int, // ID
    val title : String, // Titulo de la pelicula
    val overview : String, // Descripcion
    val releaseYear : Int, // Año de estreno
    val originalTitle : String?, // Titulo origianl
    val genres: Genres?, // El genero
    val directors : List<String>?, // Los directores
    val cast : List<String>?, // Los actores
    val rating: Int, // Promedio de puntuacion
    val runtime : Int // La duracion
)

data class Genres(
    val id : String, // ID
    val name : String // El genero
)
