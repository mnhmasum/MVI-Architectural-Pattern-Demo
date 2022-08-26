package com.paypay.currencyconverter.dependencyinjection

import com.paypay.currencyconverter.broadcastreceiver.SyncSchedulerService
import com.paypay.currencyconverter.dependencyinjection.scope.PerActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface SyncSchedulerComponent {
    fun inject(syncSchedulerService: SyncSchedulerService)
}