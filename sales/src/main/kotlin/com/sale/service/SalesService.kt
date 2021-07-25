package com.sale.service

import com.sale.domain.Sale

interface SaleService {
    fun searchStock(sale: Sale): String
}