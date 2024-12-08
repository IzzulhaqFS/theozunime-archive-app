package com.izzulhaqfs.theozunimearchiveapp

import android.app.Application
import com.izzulhaqfs.theozunimearchiveapp.core.di.databaseModule
import com.izzulhaqfs.theozunimearchiveapp.core.di.networkModule
import com.izzulhaqfs.theozunimearchiveapp.core.di.repositoryModule
import com.izzulhaqfs.theozunimearchiveapp.di.useCaseModule
import com.izzulhaqfs.theozunimearchiveapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}