package nl.sourcelabs.invoicingservice

import nl.sourcelabs.invoicingservice.pdf.*
import org.junit.*
import org.junit.runner.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.context.*
import org.springframework.test.context.junit4.*
import org.thymeleaf.context.*
import java.io.*

@RunWith(SpringRunner::class)
@SpringBootTest
class InvoicingServiceTemplatingTest {

    @Autowired
    private lateinit var exporter: TemplatePdfExporter

    @Test
    fun contextLoads() {
        val context = Context()
        context.setVariable("name", "Jarno")
        exporter.exportTemplate("invoice", context, FileOutputStream("/Users/jwalgemoed/Desktop/invoice.pdf"))
    }
}
