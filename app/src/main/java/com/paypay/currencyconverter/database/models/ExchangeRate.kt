package com.paypay.currencyconverter.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency_rate")
data class ExchangeRate(@PrimaryKey val currencyName: String, var rate: Double?) {
    val readableRate: String
        get() = String.format("%.2f", rate)

}
