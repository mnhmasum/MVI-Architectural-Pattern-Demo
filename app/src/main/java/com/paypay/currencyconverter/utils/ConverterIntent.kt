package com.paypay.currencyconverter.utils

import com.paypay.currencyconverter.database.models.CurrencyResponse

sealed class ConverterIntent {
    object Fetch : ConverterIntent()
    class Convert(val amount: Double, val baseRate: Double?) : ConverterIntent()
    class UpdateSpinner(val currencyResponse: CurrencyResponse?) : ConverterIntent()
}