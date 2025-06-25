package com.lautarodev.cineradar.shows

data class CineRadarResult(
    val shows : List<shows>
)

data class CineRadarDetailResult(
    val shows: shows
)

data class shows(
    val itemType: String = "", // Show
    val showType: String = "", // Movie o series
    val id: String = "",
    val imdbId: String = "",
    val title: String = "", // Titulo de la pelicula
    val overview: String = "", // Descripcion
    val releaseYear: Int = 0, // Año de estreno
    val originalTitle: String = "", // Titulo origianl
    val genres: List<Genre> = emptyList(), // El genero
    val directors: List<String> = emptyList(), // Los directores
    val cast: List<String> = emptyList(), // Los actores
    val rating: Int = 0, // Promedio de puntuacion
    val runtime: Int = 0, // La duracion
    val imageSet: ImageSet // imagenes
)

data class Genre(
    val id: String,
    val name: String
)

data class ImageSet(
    val verticalPoster: PosterSizes,
    val horizontalPoster: PosterSizes,
    val horizontalBackdrop: PosterSizes
)

data class PosterSizes(
    val w240: String = "",
    val w360: String = "",
    val w480: String = "",
    val w600: String = "",
    val w720: String = "",
    val w1080: String = "",
    val w1440: String = ""
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
        originalTitle = "",
        genres = emptyList(),
        directors = emptyList(),
        cast = emptyList(),
        rating = 0,
        runtime = 0,
        imageSet = ImageSet(
            verticalPoster = entyPostersizes(),
            horizontalPoster = entyPostersizes(),
            horizontalBackdrop = entyPostersizes()
        )
    )
}

fun entyPostersizes() : PosterSizes {
    return PosterSizes("","","","","","","")
}
