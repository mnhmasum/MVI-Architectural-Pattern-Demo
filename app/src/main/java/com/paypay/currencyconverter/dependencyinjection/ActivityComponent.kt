package com.paypay.currencyconverter.dependencyinjection

import com.paypay.currencyconverter.broadcastreceiver.SyncSchedulerBroadcastReceiver
import dagger.Component
import com.paypay.currencyconverter.dependencyinjection.scope.PerActivity
import com.paypay.currencyconverter.ui.currencyconverter.CurrencyConverterActivity

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(currencyActivity: CurrencyConverterActivity)
    fun inject(syncSchedulerBroadcastReceiver: SyncSchedulerBroadcastReceiver)
}