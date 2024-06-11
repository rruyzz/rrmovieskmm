package com.rodolforuiz.rrumovieskmm.domain.usecase

import com.rodolforuiz.rrumovieskmm.data.repository.HomeRepositoryImpl
import com.rodolforuiz.rrumovieskmm.domain.mapper.toDomain
import com.rodolforuiz.rrumovieskmm.domain.model.PopularMoviesDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeUseCase(
    private val repository: HomeRepositoryImpl
) {

    suspend operator fun invoke(): Flow<List<PopularMoviesDto>> {
        return repository.getHome().map { response ->
            response.results?.let { list ->
                list.map { item ->
                    item.toDomain()
                }
            } ?: listOf()
        }
    }
}