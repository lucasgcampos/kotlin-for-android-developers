package com.lucasgcampos.kotlinandroid.extensions

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {

    private var value :T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("${property.name} not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        if (this.value != null) {
            throw IllegalStateException("${property.name} already initialized")
        }

        this.value = value
    }

}
