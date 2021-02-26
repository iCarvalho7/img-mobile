package br.com.isaias.img

import android.app.Application
import androidx.multidex.MultiDex
import br.com.isaias.img.appModules
import br.com.isaias.img.viewModelModules
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