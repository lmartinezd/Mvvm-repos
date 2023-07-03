package com.dev.mvvm_repos

import android.app.Application
import com.dev.mvvm_repos.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApp)
            modules(
                listOf(
                    appModule
                )
            )
        }
    }
}