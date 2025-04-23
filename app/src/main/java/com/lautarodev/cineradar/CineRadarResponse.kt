package com.lautarodev.cineradar

data class CineRadarResult(
    val itemType: String, // "show"
    val showType: String, // "movie" o "series"
    val id: Int, // ID
    val title: String, // Titulo del show
    val overview: String, // Descripcion
    val releaseYear: Int, // Año de estreno (si es película).
    val originalTitle: String, // Título original.
    val genres: List<Genre>, // Lista de géneros (acción, comedia, etc).
    val directors: List<String>?, // Lista de directores (si es película).
    val cast: List<String>, // Lista de actores.
    val rating: Int, // Puntaje promedio de diferentes fuentes (escala del 0 al 100).
    val runtime: Int, // Duración en minutos (si es película).
    val imageSet: ImageSet, // Conjunto de imágenes (puede incluir posters, fondos, etc).
    val streamingOptions: Map<String, List<StreamingOptions>> // Información sobre dónde se puede ver el contenido en distintos países. clave es el código de país (ej: "ar")
)

data class Genre(
    val id: String,
    val name: String
)

data class ImageSet(
    val verticalPoster: Poster,
    val horizontalPoster: Poster,
    val verticalBackdrop: Poster,
    val horizontalBackdrop: Poster
)

data class Poster( // Las resoluciones de la imagenes
    val w240: String?,
    val w360: String?,
    val w480: String?,
    val w600: String?,
    val w720: String?,
    val w1080: String?,
    val w1440: String?
)


// Preguntar si esta bien =



data class StreamingOptions(
    val service: ServiceInfo,
    val type: String, // puede ser "buy, rent y addon , subscription "
    val addon: AddonInfo?,
    val link: String?,
    val quality: String?,
    val audios: List<String>?,
    val subtitles: List<String>?,
    val availableSince: Long?,
    val expiresSoon: Boolean?
)

data class ServiceInfo(
    val id: String,
    val name: String,
    val icon: String,
    val regions: List<String>,
    val monetizationTypes: List<String>
)

data class AddonInfo(
    val id: String,
    val name: String,
    val serviceId: String
)
