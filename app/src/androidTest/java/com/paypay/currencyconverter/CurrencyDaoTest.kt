package com.paypay.currencyconverter

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.paypay.currencyconverter.data.AppDatabase
import com.paypay.currencyconverter.data.CurrencyResponse
import com.paypay.currencyconverter.data.ExchangeRate
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.CoreMatchers.`is` as Is


@RunWith(AndroidJUnit4::class)
class CurrencyDaoTest {
    private var taskDatabase: AppDatabase? = null

    @Before
    fun init() {
        taskDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().context, AppDatabase::class.java).build()
    }

    @After
    fun close() {
        taskDatabase!!.close()
    }

    @Test
    fun testInsertCurrencyBaseInfo() {
        val currencyData = getDummyCurrencyResponse()
        taskDatabase?.currencyDao()?.insert(currencyData)
        val data = taskDatabase!!.currencyDao().currencyBase
        assertThat(data?.base, Is("USD"))
    }

    @Test
    fun testInsertCurrencyRatesInfo() {
        val rate = ExchangeRate("BDT", 94.62)
        val exchangeRates:ArrayList<ExchangeRate> = ArrayList()
        exchangeRates.add(rate)
        taskDatabase?.currencyDao()?.insert(exchangeRates)
        val data = taskDatabase!!.currencyDao().exchangeRates
        assertThat(data.size, Is(1))
    }

    @Test
    fun testFetchCurrencyRates() {
        val exchangeRates: ArrayList<ExchangeRate> = getRateList()
        taskDatabase?.currencyDao()?.insert(exchangeRates)
        val data = taskDatabase!!.currencyDao().exchangeRates
        assertThat(data.size, Is(2))
    }

    private fun getRateList(): ArrayList<ExchangeRate> {
        val exchangeRates: ArrayList<ExchangeRate> = ArrayList()
        exchangeRates.add(ExchangeRate("USD", 1.0))
        exchangeRates.add(ExchangeRate("BDT", 87.0))
        return exchangeRates
    }

    private fun getDummyCurrencyResponse(): CurrencyResponse {
        val currencyData = CurrencyResponse()
        currencyData.id = 1
        currencyData.base = "USD"
        return currencyData
    }

}