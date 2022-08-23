package com.paypay.currencyconverter.repository

import com.paypay.currencyconverter.database.models.CurrencyResponse
import com.paypay.currencyconverter.database.models.ExchangeRate


interface CurrencyConverterRepositoryInterface {
    suspend fun insert(currencyData: CurrencyResponse)
    suspend fun insert(exchangeRate: List<ExchangeRate>)
    suspend fun getCurrencyData(): CurrencyResponse?
    fun getCurrencyDataFromDB(): CurrencyResponse?
    fun getCurrencyBaseDB(): CurrencyResponse?
    fun getCurrencyRateDB(): List<ExchangeRate>
}