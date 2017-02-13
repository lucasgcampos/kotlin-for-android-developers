package com.lucasgcampos.kotlinandroid

import android.app.Application


class KotlinApp: Application() {

    companion object {
        var instance by DelegatesExt.notNullSingleValue<KotlinApp>()
    }

//    companion object {
//        val DB_NAME = "forecast.db"
//        val DB_VERSION = 1
//        val instance by lazy { ForecastDbHelper() }
//    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

