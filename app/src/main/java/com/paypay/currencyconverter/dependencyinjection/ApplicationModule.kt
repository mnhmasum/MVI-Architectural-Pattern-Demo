package com.paypay.currencyconverter.dependencyinjection

import android.app.Application
import androidx.room.Room
import com.paypay.currencyconverter.broadcastreceiver.SyncSchedulerService
import dagger.Module
import dagger.Provides
import com.paypay.currencyconverter.database.AppDatabase
import com.paypay.currencyconverter.database.dao.CurrencyDao
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
    @Singleton
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

    @Provides
    @Singleton
    fun provideRetrofit(appDatabase: AppDatabase): CurrencyDao {
        return appDatabase.currencyDao()
    }

}