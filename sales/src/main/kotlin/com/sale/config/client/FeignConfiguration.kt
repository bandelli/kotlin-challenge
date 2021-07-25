package com.sale.config.client

import com.sale.config.exception.CustomResponseException
import feign.Response
import feign.codec.ErrorDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.servlet.http.HttpServletResponse

@Configuration
class FeignConfiguration : ErrorDecoder {

    override fun decode(methodKey: String?, response: Response): Exception =
        when (response.status()) {
            HttpServletResponse.SC_BAD_REQUEST -> CustomResponseException("Invalid request")
            HttpServletResponse.SC_NOT_FOUND -> CustomResponseException("Session does not exist")
            HttpServletResponse.SC_INTERNAL_SERVER_ERROR -> CustomResponseException("The application Stock is down")

            else -> CustomResponseException("Fatality error")
        }
}


class CustomErrorDecoderConfiguration {

    @Bean
    fun errorDecoder(): ErrorDecoder = FeignConfiguration()
}