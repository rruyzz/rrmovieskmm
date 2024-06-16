package com.rodolforuiz.rrumovieskmm.data.repository

import com.rodolforuiz.rrumovieskmm.data.datasource.CastDataSource
import com.rodolforuiz.rrumovieskmm.data.model.CastResponse
import com.rodolforuiz.rrumovieskmm.domain.repository.CastRepository
import kotlinx.coroutines.flow.Flow

class CastRepositoryImpl(
    private val dataSource: CastDataSource

): CastRepository {
    override suspend fun getCast(movieId: String): Flow<CastResponse> {
        return dataSource.invoke(movieId)
    }
}