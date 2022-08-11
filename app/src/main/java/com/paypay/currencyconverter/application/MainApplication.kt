package com.paypay.currencyconverter.application

import android.app.Application
import com.paypay.currencyconverter.data.AppDatabase
import com.paypay.currencyconverter.dependencyinjection.ApplicationComponent
import com.paypay.currencyconverter.dependencyinjection.ApplicationModule
import com.paypay.currencyconverter.dependencyinjection.DaggerApplicationComponent
import com.paypay.currencyconverter.retrofit.initRetrofit
import javax.inject.Inject

class MainApplication : Application() {

    companion object {
        lateinit var appDatabase: AppDatabase
    }

    @Inject
    lateinit var appDatabase: AppDatabase
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initRetrofit(this)
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        applicationComponent.inject(this)
        Companion.appDatabase = appDatabase
    }

}