package com.stock.services.impl

import com.stock.domain.Stock
import com.stock.services.StockService
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class StockServiceImpl : StockService {

    companion object {
        val initialStocks = arrayOf(
            Stock(1, "Lapiseira", 20),
            Stock(2, "Caderno", 50),
            Stock(3, "Borracha", 50)
        )
    }

    var stock =
        ConcurrentHashMap<Long, Stock>(initialStocks.associateBy(Stock::id))

    fun searchByName(name: String, amount: Int): List<Stock> =
        stock.filter {
            it.value.name.contains(name, true).and(
                it.value.amount >= amount
            )
        }.map(Map.Entry<Long, Stock>::value).toList()

    override fun validateStock(name: String, amount: Int): Boolean {
        var result = searchByName(name, amount)

        if (result.isEmpty())
            return false;

        return true;
    }
}