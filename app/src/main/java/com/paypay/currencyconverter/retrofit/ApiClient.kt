package com.paypay.currencyconverter.retrofit

import com.paypay.currencyconverter.data.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("latest.json")
    suspend fun getRepositories(@Query("app_id") apiKey: String): Response<CurrencyResponse>
}

fun apiClient() : ApiClient = retrofit().create(ApiClient::class.java)