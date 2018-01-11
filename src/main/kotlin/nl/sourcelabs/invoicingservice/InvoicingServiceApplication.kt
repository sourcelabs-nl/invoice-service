package nl.sourcelabs.invoicingservice

import org.springframework.boot.*
import org.springframework.boot.autoconfigure.*
import org.springframework.context.annotation.*
import org.thymeleaf.*
import org.thymeleaf.templateresolver.*

@SpringBootApplication
class InvoicingServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(InvoicingServiceApplication::class.java, *args)
}
