package com.paypay.currencyconverter.broadcastreceiver

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.paypay.currencyconverter.application.BaseApplication
import com.paypay.currencyconverter.dependencyinjection.ActivityModule
import com.paypay.currencyconverter.dependencyinjection.DaggerActivityComponent
import com.paypay.currencyconverter.repository.CurrencyConverterRepository
import com.paypay.currencyconverter.utils.enableIntervalAPICallAlarmService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class SyncSchedulerBroadcastReceiver : BroadcastReceiver() {
     @Inject
     lateinit var currencyConverterRepository: CurrencyConverterRepository

    override fun onReceive(context: Context, intent: Intent) {
        DaggerActivityComponent.builder().applicationComponent(((context as Application) as BaseApplication).applicationComponent).activityModule(ActivityModule()).build().inject(this)

        if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
            context.enableIntervalAPICallAlarmService()
        } else {
            GlobalScope.launch(Dispatchers.IO) {
                currencyConverterRepository.getCurrencyData()
            }
        }
    }
}