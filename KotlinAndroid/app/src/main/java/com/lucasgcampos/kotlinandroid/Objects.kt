package com.lucasgcampos.kotlinandroid

import com.lucasgcampos.kotlinandroid.extensions.NotNullSingleValueVar
import kotlin.properties.ReadWriteProperty

object DelegatesExt {
    fun <T> notNullSingleValue():
            ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}