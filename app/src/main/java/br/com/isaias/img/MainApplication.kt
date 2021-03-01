package br.com.isaias.img

import android.app.Application
import androidx.multidex.MultiDex
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(viewModelModules, appModules)
            )
        }
        MultiDex.install(this)
    }
}