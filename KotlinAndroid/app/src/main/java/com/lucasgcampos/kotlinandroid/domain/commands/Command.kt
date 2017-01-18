package com.lucasgcampos.kotlinandroid.domain.commands

interface Command<T> {
    fun execute(): T
}

