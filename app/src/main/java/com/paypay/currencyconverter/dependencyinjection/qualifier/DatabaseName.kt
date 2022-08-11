package com.paypay.currencyconverter.dependencyinjection.qualifier

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

/**
 * Created by nazmul on 01/08/2022.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
annotation class DatabaseName