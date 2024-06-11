package com.rodolforuiz.rrumovieskmm.domain.mapper

import com.rodolforuiz.rrumovieskmm.data.model.PopularMoviesItem
import com.rodolforuiz.rrumovieskmm.domain.model.PopularMoviesDto

fun PopularMoviesItem.toDomain() = PopularMoviesDto(
    id = this.id ?: 0,
    titleMovie = this.titleMovie.orEmpty(),
    overview = this.overview.orEmpty(),
    posterPath = this.posterPath.orEmpty(),
    backdropPath = this.backdropPath.orEmpty(),
    releaseDate = this.releaseDate.orEmpty(),
    voteAverage = (this.voteAverage ?: 0.0).toString(),
)