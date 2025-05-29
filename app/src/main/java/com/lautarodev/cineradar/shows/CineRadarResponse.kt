package com.lautarodev.cineradar.shows

data class CineRadarResult(
    val shows : List<shows>
)

data class CineRadarDetailResult(
    val shows: shows
)

data class shows(
    val itemType : String, // Show
    val showType : String, // Movie o series
    val id : String,
    val imdbId : String,
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

fun emptyShows(): shows {
    return shows(
        itemType = "",
        showType = "",
        id = "",
        imdbId = "",
        title = "",
        overview = "",
        releaseYear = 0,
        originalTitle = null,
        genres = emptyList(),
        directors = emptyList(),
        cast = emptyList(),
        rating = 0,
        runtime = 0,
        imageSet = ImageSet(
            verticalPoster = PosterSizes(
                w240 = "",
                w360 = null,
                w480 = null,
                w600 = null,
                w720 = null,
                w1080 = null,
                w1440 = null
            ),
            horizontalPoster = null,
            horizontalBackdrop = null
        )
    )
}
