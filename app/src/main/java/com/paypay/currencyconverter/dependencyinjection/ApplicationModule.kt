package com.paypay.currencyconverter.dependencyinjection

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import com.paypay.currencyconverter.data.AppDatabase
import com.paypay.currencyconverter.data.CurrencyDao
import com.paypay.currencyconverter.dependencyinjection.qualifier.DatabaseName
import javax.inject.Singleton

@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    @DatabaseName
    fun provideDatabaseName(): String {
        return "db-pay-pay-converter"
    }

    @Provides
    fun provideDatabase(@DatabaseName dbName: String): AppDatabase {
        return Room.databaseBuilder(mApplication, AppDatabase::class.java, dbName).build()
    }

    @Provides
    @Singleton
    fun provideCurrencyDao(appDatabase: AppDatabase): CurrencyDao {
        return appDatabase.currencyDao()
    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return mApplication
    }

}