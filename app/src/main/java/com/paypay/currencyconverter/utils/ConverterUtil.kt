package com.paypay.currencyconverter.utils

import android.content.Context
import com.paypay.currencyconverter.database.models.CurrencyResponse
import com.paypay.currencyconverter.database.models.ExchangeRate

class ConverterUtil(var context: Context) {
    companion object {
        fun convertValueAndGet(selectedBase: Double?, inputValue: Double?, currencyResponse: CurrencyResponse?): List<ExchangeRate> {
            val exchangeRateList = currencyResponse?.exchangeRateList
            val updatedExchangeRateList: ArrayList<ExchangeRate> = ArrayList()
            val usDollar = getDollarRate(currencyResponse)
            if (usDollar != null && exchangeRateList != null && inputValue != null) {
                for (rate in exchangeRateList) {
                    val rateInSelectedBase = convertToBaseRate(selectedBase ?: 0.0, rate.rate ?: 0.0, usDollar.rate)
                    val result = inputValue * rateInSelectedBase
                    val newRate = ExchangeRate(rate.currencyName, result)
                    updatedExchangeRateList.add(newRate)
                }
            }

            return updatedExchangeRateList
        }

        private fun getDollarRate(currencyResponse: CurrencyResponse?): ExchangeRate? {
            return currencyResponse?.exchangeRateList?.find { it.currencyName == currencyResponse.base }
        }

        fun convertToBaseRate(baseRate: Double?, selectedCurrency: Double?, dollarRate: Double?): Double {
            return if (dollarRate != null && baseRate != null && selectedCurrency != null) {
                val selectedCurrencyToDollar = dollarRate / selectedCurrency
                val baseToDollar = dollarRate / baseRate
                baseToDollar / selectedCurrencyToDollar
            } else {
                0.0
            }
        }
    }
}