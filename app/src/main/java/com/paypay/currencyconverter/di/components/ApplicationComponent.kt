package com.paypay.currencyconverter.di.components

import android.app.Application
import com.paypay.currencyconverter.ui.base.BaseApplication
import com.paypay.currencyconverter.di.modules.ActivityModule
import com.paypay.currencyconverter.di.modules.ApplicationModule
import com.paypay.currencyconverter.di.modules.NetworkModule
import com.paypay.currencyconverter.di.modules.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, RepositoryModule::class, NetworkModule::class])
interface ApplicationComponent : AndroidInjector<BaseApplication> {
    fun activityComponent(activityModule: ActivityModule): ActivityComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}