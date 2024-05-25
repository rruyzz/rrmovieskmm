package com.rodolforuiz.rrumovieskmm.data.repository

import com.rodolforuiz.rrumovieskmm.data.datasource.HomeDataSource
import com.rodolforuiz.rrumovieskmm.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class HomeRepositoryImpl(
    private val dataSource: HomeDataSource
): HomeRepository {
    override suspend fun getHome() : Flow<String> {
        return dataSource.invoke()
    }
}