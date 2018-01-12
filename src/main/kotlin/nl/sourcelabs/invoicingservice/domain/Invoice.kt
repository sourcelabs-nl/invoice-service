package nl.sourcelabs.invoicingservice.domain

import java.math.*
import java.text.*
import java.util.*

data class Invoice(
        val invoiceNumber: String,
        val client: String,
        val invoicelines: List<InvoiceLine>) {
    val total = invoicelines.sumByDouble { it.quantity * it.price }.round()
    val vat = invoicelines.sumByDouble { it.quantity * it.price * 0.21 }.round()
    val netTotal = invoicelines.sumByDouble { it.quantity * it.price * 1.21 }.round()
    val invoiceDate = SimpleDateFormat("dd-MM-yyyy").format(Date())
}

data class InvoiceLine(
        val description: String,
        val quantity: Int,
        val price: Double) {
    val total = (quantity * price).round()
}

fun Double.round():String {
    return "%.2f".format(Locale.GERMANY, BigDecimal(this).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble())
}

fun createInvoiceData(): Invoice {
    return Invoice(
            invoiceNumber = "2018.01.00055",
            client = "Bol.com",
            invoicelines = listOf(
                    InvoiceLine(
                            description = "Jarno Walgemoed - Bol.com - Periode x",
                            quantity = 164,
                            price = 90.0
                    ),
                    InvoiceLine(
                            description = "Jarno Walgemoed - Bol.com - Periode x",
                            quantity = 5,
                            price = 2.12
                    ),
                    InvoiceLine(
                            description = "Jarno Walgemoed - Bol.com - Periode x",
                            quantity = 8,
                            price = 3.66
                    )
            )
    )
}