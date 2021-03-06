package com.lucasgcampos.kotlinandroid.domain.mappers

import com.lucasgcampos.kotlinandroid.data.server.Forecast
import com.lucasgcampos.kotlinandroid.data.server.ForecastResult
import java.util.*
import java.util.concurrent.TimeUnit
import com.lucasgcampos.kotlinandroid.domain.model.Forecast as ModelForecast


class ForecastDataMapper {

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        com.lucasgcampos.kotlinandroid.domain.model.ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}
