package com.sale.config.rabbit

import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.QueueBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueueConfig {

    @Bean
    fun jsonQueue(): Queue {
        return QueueBuilder
            .durable("SALE-QUEUE")
            .build()
    }
}