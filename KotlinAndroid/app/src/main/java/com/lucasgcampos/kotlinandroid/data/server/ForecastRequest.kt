package com.lucasgcampos.kotlinandroid.data.server

import com.google.gson.Gson
import com.lucasgcampos.kotlinandroid.data.ForecastResult
import java.net.URL

class ForecastRequest(val zipCode: String) {
    companion object {
        private val APP_ID = "54d8e9f611a6e0959b1d1471191bcbe1"
        private val endpoint = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "${endpoint}&APPID=${APP_ID}&q="
    }

    fun execute(): ForecastResult {
        val link = COMPLETE_URL + zipCode
        val forecastJsonStr = URL(link).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}

