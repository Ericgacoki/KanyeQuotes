package com.ericg.kanyequotes.api

import com.ericg.kanyequotes.model.Quote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface KanyeApi {
    @GET("/")
    suspend fun getQuote(): Response<Quote>
}