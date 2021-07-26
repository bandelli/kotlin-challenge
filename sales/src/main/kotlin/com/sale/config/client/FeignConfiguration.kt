package com.sale.config.client

import com.sale.config.exception.StockFeignErrorDecode
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfiguration {
    @Bean
    fun errorDecoder(): StockFeignErrorDecode {
        return StockFeignErrorDecode()
    }
}