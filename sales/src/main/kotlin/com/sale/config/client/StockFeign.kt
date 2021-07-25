package com.sale.config.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "\${appstock.client.name}",
    url = "\${appstock.client.url}",
    configuration = [FeignConfiguration::class]
)

interface StockFeign {

    @GetMapping("stock")
    fun validateStock(
        @RequestParam name: String,
        @RequestParam amount: String
    ): Boolean
}