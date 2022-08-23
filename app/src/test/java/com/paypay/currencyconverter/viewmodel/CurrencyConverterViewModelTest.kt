package com.paypay.currencyconverter.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.paypay.currencyconverter.utils.ConverterIntent
import com.paypay.currencyconverter.database.models.CurrencyResponse
import com.paypay.currencyconverter.utils.DataState
import com.paypay.currencyconverter.database.models.ExchangeRate
import com.paypay.currencyconverter.repo.FakeCurrencyConverterRepository
import com.paypay.currencyconverter.ui.currencyconverter.CurrencyConverterViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*

@ExperimentalCoroutinesApi
class CurrencyConverterViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var converterViewModel: CurrencyConverterViewModel
    val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        converterViewModel = CurrencyConverterViewModel(FakeCurrencyConverterRepository())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetch currency data test`() {
        runBlocking {
            val result = converterViewModel.fetchDataFromRepository()
            Assert.assertEquals(result?.base, "USD")
            Assert.assertEquals(result?.exchangeRateList?.size, 1)
        }
    }

    @Test
    fun testDefaultAppState() = runBlocking {
        val collectJob = launch(dispatcher) { converterViewModel.dataState.collect() }
        assertEquals(DataState.Idle, converterViewModel.dataState.value) // Can assert initial value
        converterViewModel.intentAction.send(ConverterIntent.Fetch)
        Thread.sleep(2000)
        assertEquals("USD", ((converterViewModel.dataState.value as DataState.Success).data?.base))
        collectJob.cancel()
    }

    @Test
    fun testCurrencyConversion() = runBlocking {
        val collectJob = launch(dispatcher) { converterViewModel.dataState.collect() }
        updateLiveData()
        assertEquals(2, converterViewModel.currencyLiveData.value!!.exchangeRateList.size)
        converterViewModel.intentAction.send(ConverterIntent.Convert(10.0, 1.0))
        Thread.sleep(2000)
        val convertedResult = (converterViewModel.dataState.value as DataState.ConversionSuccess)
        Assert.assertEquals(870.0, convertedResult.data.get(1).rate!!, 0.1)
        collectJob.cancel()
    }

    private fun updateLiveData() {
        val exchangeRates: ArrayList<ExchangeRate> = ArrayList()
        exchangeRates.add(ExchangeRate("USD", 1.0))
        exchangeRates.add(ExchangeRate("BDT", 87.0))
        val currencyData =
            CurrencyResponse()
        currencyData.id = 123
        currencyData.base = "USD"
        currencyData.license = "randomcharacters"
        currencyData.disclaimer = "some text"
        currencyData.timestamp = 1000000
        currencyData.exchangeRateList.addAll(exchangeRates)
        converterViewModel.currencyLiveData.value = currencyData
        converterViewModel.currencyLiveData.postValue(currencyData)
    }


}