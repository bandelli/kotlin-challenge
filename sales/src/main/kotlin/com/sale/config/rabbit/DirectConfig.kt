package com.sale.config.rabbit
import org.springframework.amqp.core.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DirectConfig(
    private val jsonQueue: Queue,
) {
    @Bean
    fun directExchange(): Exchange {
        return ExchangeBuilder
            .directExchange(QueueDefinition.DIRECT_EXCHANGE_SALE)
            .durable(true)
            .build()
    }

    @Bean
    fun jsonDirectBinding(): Binding {
        return BindingBuilder
            .bind(jsonQueue)
            .to(directExchange())
            .with(QueueDefinition.SALE_QUEUE_ROUTING_KEY)
            .noargs()
    }
}