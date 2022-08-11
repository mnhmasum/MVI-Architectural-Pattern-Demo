package com.paypay.currencyconverter.utils

import com.paypay.currencyconverter.data.CurrencyResponse
import com.paypay.currencyconverter.data.ExchangeRate
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ConverterUtilTest {
    @Test
    fun convert_is_correct() {
        val result = ConverterUtil.convertToBaseRate(94.62, 79.65, 1.0);
        assertEquals(0.842, result, 0.1)
    }

    @Test
    fun converted_list_correct() {
        val base = 1.0
        val inputValue = 10.0
        val result = ConverterUtil.convertValueAndGet(base, inputValue, dummyExchangeRateData()) as ArrayList
        assertEquals(result.size, 2)
        assertEquals(result[0].rate!!, 10.0, 0.1)
        assertEquals(result[1].rate!!, 946.2, 0.1)
    }

    private fun dummyExchangeRateData(): CurrencyResponse {
        val currencyData = CurrencyResponse()
        currencyData.id = 123
        currencyData.base = "USD"
        currencyData.license = "https://openexchangerates.org/license"
        currencyData.disclaimer = "some text"
        currencyData.timestamp = 1659498042
        val exchangeRateList: ArrayList<ExchangeRate> = ArrayList()
        exchangeRateList.add(ExchangeRate("USD", 1.0))
        exchangeRateList.add(ExchangeRate("BDT", 94.62))
        currencyData.setExchangeRateList(exchangeRateList)
        return currencyData
    }

}