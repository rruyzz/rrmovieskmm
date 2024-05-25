package com.rodolforuiz.rrumovieskmm.data.datasource

import com.rodolforuiz.rrumovieskmm.data.api.HomeService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeDataSource(
    private val service: HomeService
) {
    operator fun invoke(): Flow<String> {
        return flow {
            delay(5000)
            emit(service.greeting())
        }
    }
}