package com.rodolforuiz.rrumovieskmm.domain.mapper

import com.rodolforuiz.rrumovieskmm.data.model.CastResponse
import com.rodolforuiz.rrumovieskmm.domain.model.Actor
import com.rodolforuiz.rrumovieskmm.domain.model.CastMovieDto

fun CastResponse.toDomain() = CastMovieDto(
    actorList = this.cast?.map {
        it?.let{
            Actor(
                image = it.profilePath.orEmpty(),
                name = it.name.orEmpty(),
            )
        } ?: Actor("","")
    } ?: listOf()
)