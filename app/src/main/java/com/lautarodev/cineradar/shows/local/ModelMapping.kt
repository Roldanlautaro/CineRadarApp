package com.lautarodev.cineradar.shows.local


import com.lautarodev.cineradar.shows.shows



fun shows.toLocal(): ShowsLocal {
    return ShowsLocal(
        itemType = this.itemType,
        showType = this.showType,
        id = this.id,
        imdbId = this.imdbId,
        title = this.title,
        overview = this.overview,
        releaseYear = this.releaseYear,
        originalTitle = this.originalTitle,
        genres = fromGenre(this.genres),
        directors = fromDirectors(this.directors),
        cast = fromCast(this.cast),
        rating = this.rating,
        runtime = this.runtime,
        imageSet = fromImageSet(this.imageSet)
    )
}

fun ShowsLocal.toShows(): shows {
    return shows(
        itemType = this.itemType,
        showType = this.showType,
        id = this.id,
        imdbId = this.imdbId,
        title = this.title,
        overview = this.overview,
        releaseYear = this.releaseYear,
        originalTitle = this.originalTitle,
        genres = toGenre(this.genres),
        directors = toDirectors(this.directors),
        cast = toCast(this.cast),
        rating = this.rating,
        runtime = this.runtime,
        imageSet = toImageSet(this.imageSet)
    )
}
