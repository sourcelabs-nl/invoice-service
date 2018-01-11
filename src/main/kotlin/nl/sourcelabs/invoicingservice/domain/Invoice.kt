package nl.sourcelabs.invoicingservice.domain

data class Invoice(
        val invoiceNumber: String,
        val clientId: String,
        val employeeId: String
)