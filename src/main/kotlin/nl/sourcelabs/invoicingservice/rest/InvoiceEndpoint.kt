package nl.sourcelabs.invoicingservice.rest

import nl.sourcelabs.invoicingservice.domain.*
import nl.sourcelabs.invoicingservice.pdf.*
import org.springframework.web.bind.annotation.*
import org.thymeleaf.context.*
import javax.servlet.*
import javax.servlet.http.*

@RestController
class InvoiceEndpoint(val exporter: TemplatePdfExporter, val servletContext: ServletContext) {

    @GetMapping("/api/invoice")
    fun getInvoice(request: HttpServletRequest, response: HttpServletResponse) {
        val context = WebContext(request, response, servletContext)
        context.setVariable("invoice", createInvoiceData())

        exporter.exportTemplate("invoice", context, response.outputStream)
    }
}