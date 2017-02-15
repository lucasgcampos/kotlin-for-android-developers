package com.lucasgcampos.kotlinandroid.domain.commands

import com.lucasgcampos.kotlinandroid.data.server.ForecastRequest
import com.lucasgcampos.kotlinandroid.domain.mappers.ForecastDataMapper
import com.lucasgcampos.kotlinandroid.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: Long) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }

}
