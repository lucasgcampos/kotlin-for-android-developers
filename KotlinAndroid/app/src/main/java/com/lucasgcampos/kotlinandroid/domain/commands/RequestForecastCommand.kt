package com.lucasgcampos.kotlinandroid.domain.commands

import com.lucasgcampos.kotlinandroid.data.server.ForecastRequest
import com.lucasgcampos.kotlinandroid.data.server.ForecastDataMapper
import com.lucasgcampos.kotlinandroid.data.model.ForecastList

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}

