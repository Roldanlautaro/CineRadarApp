package com.lautarodev.cineradar

data class CineRadarResult(
    val shows : List<shows>
)

data class shows(
    val itemType : String, // Show
    val showType : String, // Movie o series
    val id : Int, // ID
    val title : String, // Titulo de la pelicula
    val overview : String, // Descripcion
    val releaseYear : Int, // Año de estreno
    val originalTitle : String?, // Titulo origianl
    val genres: List<Genre>?, // El genero
    val directors : List<String>?, // Los directores
    val cast : List<String>?, // Los actores
    val rating: Int, // Promedio de puntuacion
    val runtime : Int, // La duracion
    val imageSet: ImageSet // imagenes
)

data class Genre(
    val id: String,
    val name: String
)

data class ImageSet(
    val verticalPoster: PosterSizes?,
    val horizontalPoster: PosterSizes?,
    val horizontalBackdrop: PosterSizes?
)


data class PosterSizes(
    val w240: String?,
    val w360: String?,
    val w480: String?,
    val w600: String?,
    val w720: String?,
    val w1080: String?,  // Solo para algunas resoluciones
    val w1440: String?
)