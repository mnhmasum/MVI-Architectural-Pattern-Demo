package com.paypay.currencyconverter.application

import android.app.Application
import com.paypay.currencyconverter.dependencyinjection.ApplicationComponent
import com.paypay.currencyconverter.dependencyinjection.ApplicationModule
import com.paypay.currencyconverter.dependencyinjection.DaggerApplicationComponent
import com.paypay.currencyconverter.network.initRetrofit

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initRetrofit(this)
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        applicationComponent.inject(this)
    }

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

}