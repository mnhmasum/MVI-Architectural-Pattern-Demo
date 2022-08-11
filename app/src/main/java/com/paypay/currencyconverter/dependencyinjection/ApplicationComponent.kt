package com.paypay.currencyconverter.dependencyinjection

import dagger.Component
import com.paypay.currencyconverter.application.MainApplication
import com.paypay.currencyconverter.data.CurrencyDao
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(app: MainApplication)
    fun exposeCurrencyDao(): CurrencyDao
}