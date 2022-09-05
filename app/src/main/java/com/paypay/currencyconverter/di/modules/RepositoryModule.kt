package com.paypay.currencyconverter.di.modules

import com.paypay.currencyconverter.database.dao.CurrencyDao
import com.paypay.currencyconverter.network.ExchangeRateAPI
import com.paypay.currencyconverter.repository.CurrencyConverterRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by nazmul 08/06/2022.
 */
@Module
class RepositoryModule() {

    @Provides
    @Singleton
    fun provideCurrencyRepository(currencyDao: CurrencyDao, exchangeRateAPI: ExchangeRateAPI): CurrencyConverterRepository {
        return CurrencyConverterRepository(currencyDao, exchangeRateAPI)
    }

}