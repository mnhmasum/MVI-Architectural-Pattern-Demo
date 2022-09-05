package com.paypay.currencyconverter.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.paypay.currencyconverter.ui.base.BaseApplication
import com.paypay.currencyconverter.di.modules.ActivityModule
import com.paypay.currencyconverter.repository.CurrencyConverterRepository
import com.paypay.currencyconverter.utils.enableIntervalAPICallAlarmService
import kotlinx.coroutines.*
import javax.inject.Inject


class SyncSchedulerService : BroadcastReceiver() {
    @Inject
    lateinit var converterRepository: CurrencyConverterRepository

    override fun onReceive(context: Context, intent: Intent) {
        BaseApplication.appComponent
                .activityComponent(ActivityModule())
                .inject(this)

        performSyncService(intent, context)
    }

    private fun performSyncService(intent: Intent, context: Context) {
        if (Intent.ACTION_BOOT_COMPLETED == intent.action) {
            startSyncService(context)
        } else {
            startSyncing()
        }
    }

    private fun startSyncing() {
        GlobalScope.launch(Dispatchers.IO) {
            converterRepository.getCurrencyData()
        }
    }

    private fun startSyncService(context: Context) {
        context.enableIntervalAPICallAlarmService()
    }
}