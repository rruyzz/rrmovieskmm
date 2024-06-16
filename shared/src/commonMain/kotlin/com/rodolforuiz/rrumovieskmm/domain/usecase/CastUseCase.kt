package com.rodolforuiz.rrumovieskmm.domain.usecase

import com.rodolforuiz.rrumovieskmm.data.repository.CastRepositoryImpl
import com.rodolforuiz.rrumovieskmm.domain.mapper.toDomain
import com.rodolforuiz.rrumovieskmm.domain.model.CastMovieDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CastUseCase(
    private val repository: CastRepositoryImpl
) {
    suspend operator fun invoke(movieId:String): Flow<CastMovieDto> {
        return repository.getCast(movieId = movieId).map { response ->
           response.toDomain()
        }
    }
}