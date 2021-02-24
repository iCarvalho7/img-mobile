package br.com.isaias.img.ui

import android.app.Application
import androidx.multidex.MultiDex

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }
}