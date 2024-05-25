package com.rodolforuiz.rrumovieskmm.data.api

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class HomeService {
    private val client = HttpClient()

    suspend fun greeting(): String {
        val response = client.get("https://ktor.io/docs/")
        return response.bodyAsText()
    }
}