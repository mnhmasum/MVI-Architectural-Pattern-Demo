package com.paypay.currencyconverter.di.components

import com.paypay.currencyconverter.broadcastreceiver.SyncSchedulerService
import com.paypay.currencyconverter.di.modules.ActivityModule
import com.paypay.currencyconverter.di.scope.PerActivity
import com.paypay.currencyconverter.ui.currencyconverter.CurrencyConverterActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(syncSchedulerService: SyncSchedulerService)
    fun inject(currencyConverterActivity: CurrencyConverterActivity)
}