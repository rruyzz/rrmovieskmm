package com.rodolforuiz.rrumovieskmm.domain.model

data class CastMovieDto(
    val actorList: List<Actor>
)

data class Actor(
    val image: String,
    val name: String
)