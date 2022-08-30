package com.paypay.currencyconverter.application

import android.app.Application
import com.paypay.currencyconverter.dependencyinjection.components.ApplicationComponent
import com.paypay.currencyconverter.dependencyinjection.components.DaggerApplicationComponent
import com.paypay.currencyconverter.dependencyinjection.modules.ApplicationModule

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(ApplicationModule(this))

    }

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

}