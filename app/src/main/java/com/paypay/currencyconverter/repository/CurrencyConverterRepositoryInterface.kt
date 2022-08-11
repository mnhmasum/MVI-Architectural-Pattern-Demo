package com.paypay.currencyconverter.repository

import com.paypay.currencyconverter.data.CurrencyResponse
import com.paypay.currencyconverter.data.ExchangeRate


interface CurrencyConverterRepositoryInterface {
    suspend fun insert(currencyData: CurrencyResponse)
    suspend fun insert(exchangeRate: List<ExchangeRate>)
    suspend fun getCurrencyData(): CurrencyResponse?
    fun getCurrencyDataFromDB(): CurrencyResponse?
    fun getCurrencyBaseDB(): CurrencyResponse?
    fun getCurrencyRateDB(): List<ExchangeRate>
}