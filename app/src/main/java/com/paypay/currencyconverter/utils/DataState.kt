package com.paypay.currencyconverter.utils

import com.paypay.currencyconverter.database.models.CurrencyResponse
import com.paypay.currencyconverter.database.models.ExchangeRate

sealed class DataState {
    object Idle : DataState()
    object Loading : DataState()
    data class Success(val data: CurrencyResponse?) : DataState()
    data class ConversionSuccess(val data: List<ExchangeRate>) : DataState()
    data class Error(val error: String) : DataState()
}