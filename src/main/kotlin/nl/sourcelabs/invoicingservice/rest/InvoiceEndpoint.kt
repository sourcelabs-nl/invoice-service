package nl.sourcelabs.invoicingservice.rest

import nl.sourcelabs.invoicingservice.pdf.*
import org.springframework.web.bind.annotation.*
import org.thymeleaf.context.*
import javax.servlet.http.*

@RestController
class InvoiceEndpoint(val exporter: TemplatePdfExporter) {

    @GetMapping("/api/invoice")
    fun getInvoice(response: HttpServletResponse) {
        val context = Context()
        context.setVariable("name", "Jarno")

        exporter.exportTemplate("invoice", context, response.outputStream)
    }
}