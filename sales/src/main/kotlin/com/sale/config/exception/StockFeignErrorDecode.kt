package com.sale.config.exception

import feign.Response
import feign.codec.ErrorDecoder
import javax.servlet.http.HttpServletResponse

class StockFeignErrorDecode : ErrorDecoder {

    override fun decode(methodKey: String?, response: Response): Exception =
        when (response.status()) {
            HttpServletResponse.SC_BAD_REQUEST -> CustomResponseException("Invalid request")
            HttpServletResponse.SC_NOT_FOUND -> CustomResponseException("Session does not exist")
            HttpServletResponse.SC_INTERNAL_SERVER_ERROR -> CustomResponseException("The application Stock is down")

            else -> CustomResponseException("Fatality error")
        }
}