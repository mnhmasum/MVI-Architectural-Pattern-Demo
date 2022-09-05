package com.paypay.currencyconverter.di.modules

import com.paypay.currencyconverter.di.scope.PerActivity
import com.paypay.currencyconverter.repository.CurrencyConverterRepository
import com.paypay.currencyconverter.ui.currencyconverter.CurrencyConverterViewModel
import com.paypay.currencyconverter.ui.currencyconverter.CurrencyViewAdapter
import dagger.Module
import dagger.Provides

/**
 * Created by nazmul 08/06/2022.
 */
@Module
class ActivityModule() {

    @Provides
    @PerActivity
    fun provideCurrencyViewModel(currencyListRepository: CurrencyConverterRepository): CurrencyConverterViewModel {
        return CurrencyConverterViewModel(currencyListRepository)
    }

    @Provides
    @PerActivity
    fun provideCurrencyViewAdapter(currencyConverterViewModel: CurrencyConverterViewModel): CurrencyViewAdapter {
        return CurrencyViewAdapter(currencyConverterViewModel)
    }

}