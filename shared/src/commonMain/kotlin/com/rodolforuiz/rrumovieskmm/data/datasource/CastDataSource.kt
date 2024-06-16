package com.rodolforuiz.rrumovieskmm.data.datasource

import com.rodolforuiz.rrumovieskmm.data.api.CastService
import com.rodolforuiz.rrumovieskmm.data.model.CastResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CastDataSource(
    private val service: CastService
) {
    operator fun invoke(movieId: String): Flow<CastResponse> {
        return flow {
            emit(service.getCast(movieId = movieId))
        }
    }
}