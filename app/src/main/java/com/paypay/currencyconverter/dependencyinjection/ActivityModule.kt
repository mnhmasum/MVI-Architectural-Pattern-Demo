package com.paypay.currencyconverter.dependencyinjection

import android.content.Context
import com.paypay.currencyconverter.data.CurrencyDao
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
class ActivityModule(private val context: Context) {

    @Provides
    fun provideCurrencyRepository(currencyDao: CurrencyDao): CurrencyConverterRepository {
        return CurrencyConverterRepository(currencyDao)
    }

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