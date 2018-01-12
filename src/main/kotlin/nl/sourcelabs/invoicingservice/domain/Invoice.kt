package nl.sourcelabs.invoicingservice.domain

import java.math.*
import java.text.*
import java.util.*

data class Invoice(
        val invoiceNumber: String,
        val client: String,
        val invoicelines: List<InvoiceLine>,
        val vatMultiplier: Double = 0.21) {
    val total = invoicelines.sumByDouble { it.quantity * it.price }.round()
    val vat = invoicelines.sumByDouble { it.quantity * it.price * vatMultiplier }.round()
    val netTotal = invoicelines.sumByDouble { it.quantity * it.price * (1 + vatMultiplier) }.round()
    val invoiceDate = SimpleDateFormat("dd-MM-yyyy").format(Date())
    val vatPercentage = "%.0f".format(vatMultiplier * 100) + " %"
}

data class InvoiceLine(
        val description: String,
        val quantity: Int,
        val price: Double) {
    val total = (quantity * price).round()
}

fun Double.round(): String {
    return "%.2f".format(Locale.GERMANY, BigDecimal(this).setScale(2, BigDecimal.ROUND_HALF_UP).toDouble())
}

fun createInvoiceData(): Invoice {
    return Invoice(
            invoiceNumber = "2018.01.00055",
            client = "Bol.com",
            invoicelines = listOf(
                    InvoiceLine(
                            description = "Inzet, uurtje factuurtje",
                            quantity = 164,
                            price = 90.0
                    ),
                    InvoiceLine(
                            description = "Hosting",
                            quantity = 5,
                            price = 2.12
                    ),
                    InvoiceLine(
                            description = "Facturatie",
                            quantity = 8,
                            price = 3.66
                    )
            )
    )
}