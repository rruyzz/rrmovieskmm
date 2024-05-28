package com.rodolforuiz.rrumovieskmm.data.datasource

import com.rodolforuiz.rrumovieskmm.data.api.HomeService
import com.rodolforuiz.rrumovieskmm.data.model.PopularMoviesResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeDataSource(
    private val service: HomeService
) {
    operator fun invoke(): Flow<PopularMoviesResponse> {
        return flow {
            emit(service.getPopularMovies())
        }
    }
}