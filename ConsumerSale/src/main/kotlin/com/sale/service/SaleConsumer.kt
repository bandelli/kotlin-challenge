package com.sale.service


import com.sale.domain.Sale
import org.slf4j.LoggerFactory
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.stereotype.Service

@Service
class SaleConsumer(
    private val messageConverter: MessageConverter
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @RabbitListener(queues = ["SALE-QUEUE"])
    fun receiveMessageFromJsonQueue(message: Message) {
        log.info(">receive sale from ${message.messageProperties.consumerQueue}")
        val sale = messageConverter.fromMessage(message) as Sale
        log.info("body $sale")
    }
}