package com.paypay.currencyconverter.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.paypay.currencyconverter.application.MainApplication
import com.paypay.currencyconverter.repository.CurrencyConverterRepository
import com.paypay.currencyconverter.utils.enableIntervalAPICallAlarmService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class AlarmBroadcastReceiver : BroadcastReceiver() {
    lateinit var context: Context
    override fun onReceive(context: Context, intent: Intent) {
        this.context = context
        if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
            context.enableIntervalAPICallAlarmService()
        } else {
            GlobalScope.launch(Dispatchers.IO) {
                val repository = CurrencyConverterRepository(MainApplication.appDatabase.currencyDao())
                repository.getCurrencyData()
                Log.d("Alarm Fired", "Sync Completed!!")
            }
        }
    }
}