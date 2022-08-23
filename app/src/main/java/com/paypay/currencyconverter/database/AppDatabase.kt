package com.paypay.currencyconverter.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.paypay.currencyconverter.database.dao.CurrencyDao
import com.paypay.currencyconverter.database.models.CurrencyResponse
import com.paypay.currencyconverter.database.models.ExchangeRate

@Database(entities = [CurrencyResponse::class, ExchangeRate::class], version = 1, exportSchema = true)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
}