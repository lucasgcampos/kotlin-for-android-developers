package com.lucasgcampos.kotlinandroid.data.server

import com.lucasgcampos.kotlinandroid.data.Forecast
import com.lucasgcampos.kotlinandroid.data.ForecastResult
import java.text.DateFormat
import java.util.*
import com.lucasgcampos.kotlinandroid.domain.model.ForecastList as ModelForecast


class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): com.lucasgcampos.kotlinandroid.domain.model.ForecastList {
        return com.lucasgcampos.kotlinandroid.domain.model.ForecastList(forecast.city.id, forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>):
            List<com.lucasgcampos.kotlinandroid.domain.model.Forecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): com.lucasgcampos.kotlinandroid.domain.model.Forecast {
        return com.lucasgcampos.kotlinandroid.domain.model.Forecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"

}
