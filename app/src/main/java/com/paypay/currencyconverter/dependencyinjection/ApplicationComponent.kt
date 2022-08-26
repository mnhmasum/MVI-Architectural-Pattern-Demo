package com.paypay.currencyconverter.dependencyinjection

import dagger.Component
import com.paypay.currencyconverter.application.BaseApplication
import com.paypay.currencyconverter.database.dao.CurrencyDao
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(app: BaseApplication)
    fun exposeCurrencyDao(): CurrencyDao
    fun synSchedulerComponent(activityModule: ActivityModule): SyncSchedulerComponent
}