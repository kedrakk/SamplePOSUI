package com.example.sampleposui.data

data class Invoice(
    val invoiceDate: String,
    val invoiceNo: String,
    val quantity: Int,
    val amount: Double,
)

val invoiceList: List<Invoice> = listOf<Invoice>(
    Invoice("30/01/2019", "Inv-001", quantity = 15, amount = 12500.0),
    Invoice("30/01/2019", "Inv-002", quantity = 10, amount = 5000.0),
    Invoice("30/01/2019", "Inv-003", quantity = 10, amount = 10000.0),
)


