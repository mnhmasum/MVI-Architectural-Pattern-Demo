package com.paypay.currencyconverter.data

sealed class DataState {
    object Idle : DataState()
    object Loading : DataState()
    data class Success(val data: CurrencyResponse?) : DataState()
    data class ConversionSuccess(val data: List<ExchangeRate>) : DataState()
    data class Error(val error: String) : DataState()
}