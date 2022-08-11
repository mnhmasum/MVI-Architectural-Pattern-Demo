package com.paypay.currencyconverter.dependencyinjection

import dagger.Component
import com.paypay.currencyconverter.dependencyinjection.scope.PerActivity
import com.paypay.currencyconverter.ui.currencyconverter.CurrencyConverterActivity

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface MainActivityComponent {
    fun inject(currencyActivity: CurrencyConverterActivity)
}