package com.paypay.currencyconverter.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.paypay.currencyconverter.application.BaseApplication
import com.paypay.currencyconverter.dependencyinjection.modules.ActivityModule
import com.paypay.currencyconverter.repository.CurrencyConverterRepository
import com.paypay.currencyconverter.utils.enableIntervalAPICallAlarmService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class SyncSchedulerService : BroadcastReceiver() {
    @Inject
    lateinit var currencyConverterRepository: CurrencyConverterRepository

    override fun onReceive(context: Context, intent: Intent) {
        BaseApplication.applicationComponent.activityComponent(ActivityModule()).inject(this)

        if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
            context.enableIntervalAPICallAlarmService()
            Log.d("Fired", "onReceive: ")
        } else {
            GlobalScope.launch(Dispatchers.IO) {
                currencyConverterRepository.getCurrencyData()
                Log.d("Fired", "onReceive: done ")
            }
        }
    }
}