package com.sale.controller

import com.sale.domain.Sale
import com.sale.service.SaleService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["sale"])
class SalesController(var saleService: SaleService) {

    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping
    fun createSale(@RequestBody sale: Sale): ResponseEntity<Any?> {
        log.info("sending sale $sale")
        var result = saleService.searchStock(sale);
        return ResponseEntity(result, HttpStatus.OK)
    }
}