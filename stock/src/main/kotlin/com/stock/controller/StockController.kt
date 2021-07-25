package com.stock.controller

import com.stock.services.StockService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["stock"])
class StockController(var stockService: StockService) {

    private val log = LoggerFactory.getLogger(javaClass)

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun findStock(
        @RequestParam name: String,
        @RequestParam amount: String
    ): ResponseEntity<Boolean> {
        log.info("sending sale $name and amount $amount")
        var stock = this.stockService.validateStock(name, amount.toInt())

        if (stock.equals(false)) {
            return ResponseEntity(stock, HttpStatus.NOT_FOUND)
        }

        return ResponseEntity(stock, HttpStatus.OK)
    }
}