package com.paypay.currencyconverter.apiclient

import com.paypay.currencyconverter.network.apiClient
import com.paypay.currencyconverter.network.initRetrofit
import com.paypay.currencyconverter.utils.Constant
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ApiCallClientTest {
    @Test
    fun testPlacesService() {
        runBlocking {
            initRetrofit()
            val result = apiClient().getRepositories(Constant.API_KEY)
            val error = result.errorBody()
            assert(error == null)
            val response = result.body()
            assert(response != null)
            assert(result.code() == 200)
        }
    }
}