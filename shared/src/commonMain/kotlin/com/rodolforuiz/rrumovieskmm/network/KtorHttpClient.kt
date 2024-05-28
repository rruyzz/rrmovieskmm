package com.rodolforuiz.rrumovieskmm.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import co.touchlab.kermit.Logger as KermitLog
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json

class KtorHttpClient {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }

        install(Logging)  {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
            logger = object: Logger {
                override fun log(message: String) {
                    KermitLog.withTag(tag = "KtorClient").i {
                        message
                    }
                }
            }
        }
        defaultRequest {
            url {
                url("https://api.themoviedb.org/3/")
                parameters.append("api_key", "e591023d8d396231d3045ea6341a6fd2")
                parameters.append("language", "pt-BR")
            }
        }
    }

    suspend fun getKtorEndpoint(endPoint: String): HttpResponse {
        val response = client.get(endPoint)
        return response
    }
}