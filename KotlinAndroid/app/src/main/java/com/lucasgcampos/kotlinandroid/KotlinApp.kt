package com.lucasgcampos.kotlinandroid

import android.app.Application


class KotlinApp: Application() {

    companion object {
        var instance by DelegatesExt.notNullSingleValue<KotlinApp>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

