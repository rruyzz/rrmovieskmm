package com.rodolforuiz.rrumovieskmm.domain.model

data class PopularMoviesDto(
    val id: Int,
    val titleMovie: String,
    val overview: String,
    val posterPath: String,
    val backdropPath: String,
    val releaseDate: String,
    val voteAverage: String,
)