package com.paypay.currencyconverter.ui.currencyconverter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paypay.currencyconverter.utils.DataState
import com.paypay.currencyconverter.utils.ConverterIntent
import com.paypay.currencyconverter.utils.ConverterIntent.*
import com.paypay.currencyconverter.database.models.CurrencyResponse
import com.paypay.currencyconverter.database.models.ExchangeRate
import com.paypay.currencyconverter.repository.CurrencyConverterRepositoryInterface
import com.paypay.currencyconverter.utils.ConverterUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class CurrencyConverterViewModel internal constructor(private val currencyRepoInterface: CurrencyConverterRepositoryInterface) :
    ViewModel() {
    val intentAction = Channel<ConverterIntent>()
    val currencyLiveData = MutableLiveData<CurrencyResponse>()
    private var selectedRate = MutableLiveData(0.0)
    private val _dataState = MutableStateFlow<DataState>(DataState.Idle)
    val dataState: StateFlow<DataState>
        get() = _dataState

    init {
        handleIntentAction()
    }

    private fun handleIntentAction() {
        viewModelScope.launch {
            intentAction.consumeAsFlow().collect {
                when (it) {
                    is Fetch -> fetchCurrencyExchangeData()
                    is UpdateSpinner -> updateSpinner(it.currencyResponse)
                    is Convert -> startConversion(it)
                }
            }
        }
    }

    private fun fetchCurrencyExchangeData() {
        viewModelScope.launch(Dispatchers.IO) {
            _dataState.value = DataState.Loading
            _dataState.value = DataState.Success(fetchDataFromRepository())
        }
    }

    suspend fun fetchDataFromRepository(): CurrencyResponse? {
        return currencyRepoInterface.getCurrencyData()
    }

    private fun updateSpinner(currencyResponse: CurrencyResponse?) {
        currencyResponse?.let { currencyLiveData.postValue(it) }
    }

    private fun startConversion(it: Convert) {
        viewModelScope.launch(Dispatchers.IO) {
            _dataState.value = DataState.Loading
            _dataState.value = DataState.ConversionSuccess(getConvertedCurrencyList(it))
        }
    }

    private fun getConvertedCurrencyList(it: Convert): List<ExchangeRate> {
        it.baseRate?.let { selectedRate.postValue(it) }
        val convertedRateList = ConverterUtil.convertValueAndGet(it.baseRate, it.amount, currencyLiveData.value)
        if (it.amount == 0.0) (convertedRateList as ArrayList<ExchangeRate>).clear()
        return convertedRateList
    }

    fun onTextChangeComplete(text: CharSequence?) {
        val input = if (text.toString().isNotEmpty()) text.toString().toDouble() else 0.0
        viewModelScope.launch(Dispatchers.IO) {
            intentAction.send(Convert(input, selectedRate.value))
        }
    }

}