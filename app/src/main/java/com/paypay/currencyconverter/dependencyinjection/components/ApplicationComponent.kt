package com.paypay.currencyconverter.dependencyinjection.components

import com.paypay.currencyconverter.application.BaseApplication
import com.paypay.currencyconverter.dependencyinjection.modules.ActivityModule
import com.paypay.currencyconverter.dependencyinjection.modules.ApplicationModule
import com.paypay.currencyconverter.dependencyinjection.modules.NetworkModule
import com.paypay.currencyconverter.dependencyinjection.modules.RepositoryModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, RepositoryModule::class, NetworkModule::class])
interface ApplicationComponent : AndroidInjector<BaseApplication> {
    fun activityComponent(activityModule: ActivityModule): ActivityComponent

    @Component.Factory
    interface Factory {
        fun create(applicationModule: ApplicationModule): ApplicationComponent
    }
}