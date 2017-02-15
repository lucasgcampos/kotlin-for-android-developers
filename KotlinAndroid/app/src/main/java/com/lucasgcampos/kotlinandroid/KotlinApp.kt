package com.lucasgcampos.kotlinandroid

import android.app.Application
import com.lucasgcampos.kotlinandroid.extensions.DelegatesExt


class KotlinApp: Application() {

    companion object {
        var instance: KotlinApp by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

