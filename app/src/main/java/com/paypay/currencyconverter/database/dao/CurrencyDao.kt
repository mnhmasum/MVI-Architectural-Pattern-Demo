package com.paypay.currencyconverter.database.dao

import androidx.room.*
import com.paypay.currencyconverter.database.models.CurrencyResponse
import com.paypay.currencyconverter.database.models.ExchangeRate

@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(rate: CurrencyResponse?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exchangeRate: ExchangeRate?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exchangeRates: List<ExchangeRate?>?)

    @get:Query("SELECT * FROM currency_rate")
    val exchangeRates: List<ExchangeRate>

    @get:Query("SELECT * FROM currency_base LIMIT 1")
    val currencyBase: CurrencyResponse?
}