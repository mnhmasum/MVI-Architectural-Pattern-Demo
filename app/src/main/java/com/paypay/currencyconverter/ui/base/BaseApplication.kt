package com.paypay.currencyconverter.ui.base

import android.app.Application
import com.paypay.currencyconverter.di.components.ApplicationComponent
import com.paypay.currencyconverter.di.components.DaggerApplicationComponent

class BaseApplication : Application() {

    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(this)
    }

}