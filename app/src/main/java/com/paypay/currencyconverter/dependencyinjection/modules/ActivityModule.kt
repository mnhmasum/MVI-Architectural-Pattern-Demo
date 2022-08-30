package com.paypay.currencyconverter.dependencyinjection.modules

import com.paypay.currencyconverter.database.dao.CurrencyDao
import com.paypay.currencyconverter.dependencyinjection.scope.PerActivity
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