package com.rodolforuiz.rrumovieskmm.data.api

import com.rodolforuiz.rrumovieskmm.data.model.CastResponse
import com.rodolforuiz.rrumovieskmm.network.KtorHttpClient
import io.ktor.client.call.body

class CastService {
    private val ktorHttpClient = KtorHttpClient()
    suspend fun getCast(movieId: String): CastResponse {
        return ktorHttpClient.getKtorEndpoint("movie/${movieId}/credits").body<CastResponse>()
    }
}