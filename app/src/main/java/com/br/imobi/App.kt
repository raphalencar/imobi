package com.br.imobi

import android.app.Application
import com.br.imobi.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App: Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    private fun configureDi() {
        startKoin {
            androidContext(applicationContext)
            modules(provideComponent())
        }
    }

    open fun provideComponent() = appComponent
}