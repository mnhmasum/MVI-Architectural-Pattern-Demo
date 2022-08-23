package com.paypay.currencyconverter.application

import android.app.Application
import com.paypay.currencyconverter.database.AppDatabase
import com.paypay.currencyconverter.dependencyinjection.ApplicationComponent
import com.paypay.currencyconverter.dependencyinjection.ApplicationModule
import com.paypay.currencyconverter.dependencyinjection.DaggerApplicationComponent
import com.paypay.currencyconverter.network.initRetrofit
import javax.inject.Inject

class BaseApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initRetrofit(this)
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        applicationComponent.inject(this)
    }

}