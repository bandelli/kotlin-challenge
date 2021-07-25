package com.sale.service.impl

import com.sale.config.client.StockFeign
import com.sale.config.rabbit.QueueDefinition
import com.sale.domain.Sale
import com.sale.service.SaleService
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class SalesServiceImpl(
    private val rabbitTemplate: RabbitTemplate,
    private val stockFeign: StockFeign
) : SaleService {

    override fun searchStock(sale: Sale): String {

        var validatedStock = consultingStockApp(sale)

        if (validatedStock == true) {
            rabbitTemplate.convertAndSend(
                QueueDefinition.DIRECT_EXCHANGE_SALE, QueueDefinition.SALE_QUEUE_ROUTING_KEY, sale
            )
            return "Venda efetuada"
        }

        return "Venda não efetuada por falta de estoque"
    }

    private fun consultingStockApp(sale: Sale): Boolean {
        var validatedStock = stockFeign.validateStock(sale.name, sale.amount.toString())
        return validatedStock
    }
}