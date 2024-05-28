package com.rodolforuiz.rrumovieskmm.domain.usecase

import com.rodolforuiz.rrumovieskmm.data.model.PopularMoviesResponse
import com.rodolforuiz.rrumovieskmm.data.repository.HomeRepositoryImpl
import kotlinx.coroutines.flow.Flow

class HomeUseCase(
    private val repository: HomeRepositoryImpl
) {

    suspend operator fun invoke(): Flow<PopularMoviesResponse> {
        return repository.getHome()
    }
}