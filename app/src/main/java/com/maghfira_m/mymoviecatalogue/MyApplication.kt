package com.maghfira_m.mymoviecatalogue

import android.app.Application
import com.maghfira_m.mymoviecatalogue.core.di.databaseModule
import com.maghfira_m.mymoviecatalogue.core.di.networkModule
import com.maghfira_m.mymoviecatalogue.core.di.repositoryModule
import com.maghfira_m.mymoviecatalogue.di.useCaseModule
import com.maghfira_m.mymoviecatalogue.di.viewModelModule
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
                    viewModelModule
                )
            )
        }
    }
}