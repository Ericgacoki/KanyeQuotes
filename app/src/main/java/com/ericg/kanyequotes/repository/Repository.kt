package com.ericg.kanyequotes.repository

import com.ericg.kanyequotes.model.Quote
import com.ericg.kanyequotes.retrofit.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getQuote(): Response<Quote> {
        return RetrofitInstance.api.getQuote()
    }
}