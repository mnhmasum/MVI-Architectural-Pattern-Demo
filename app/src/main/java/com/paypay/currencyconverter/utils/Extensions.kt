package com.paypay.currencyconverter.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.paypay.currencyconverter.broadcastreceiver.AlarmBroadcastReceiver
import com.paypay.currencyconverter.databinding.ActivityCurrencyConvertBinding

fun Context.enableIntervalAPICallAlarmService() {
    val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val intent = Intent(this, AlarmBroadcastReceiver::class.java)
    val alarmPendingIntent =
        PendingIntent.getBroadcast(this, Constant.ALARM_REQUEST_CODE, intent, 0)
    alarmManager.setInexactRepeating(
        AlarmManager.ELAPSED_REALTIME_WAKEUP,
        AlarmManager.INTERVAL_HALF_HOUR,
        AlarmManager.INTERVAL_HALF_HOUR, alarmPendingIntent
    )
}

fun getUserInput(binding: ActivityCurrencyConvertBinding): Double {
    return if (!binding.editTextNumber.text.isNullOrEmpty()) binding.editTextNumber.text.toString()
        .toDouble() else 0.0
}

