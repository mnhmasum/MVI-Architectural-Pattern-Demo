package com.paypay.currencyconverter.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.paypay.currencyconverter.database.models.ExchangeRate

class Converters {

    @TypeConverter
    fun listToJson(value: List<ExchangeRate>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<ExchangeRate>::class.java).toList()
}