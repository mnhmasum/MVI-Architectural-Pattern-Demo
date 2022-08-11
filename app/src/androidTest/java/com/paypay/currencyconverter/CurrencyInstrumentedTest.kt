package com.paypay.currencyconverter

import android.app.Application
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.paypay.currencyconverter.retrofit.apiClient
import com.paypay.currencyconverter.retrofit.initRetrofit
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CurrencyInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        initRetrofit(appContext.applicationContext as Application)
        val client = apiClient()
        assertNotNull(client)
        assertEquals("com.paypay.currencyconverter", appContext.packageName)
    }
}