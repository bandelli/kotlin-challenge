package com.stock.services

interface StockService {
    fun validateStock(name: String, amount: Int): Boolean
}