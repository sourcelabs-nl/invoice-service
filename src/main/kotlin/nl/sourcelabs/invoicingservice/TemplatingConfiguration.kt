package nl.sourcelabs.invoicingservice

import org.springframework.context.annotation.*
import org.springframework.context.annotation.Configuration
import org.thymeleaf.*
import org.thymeleaf.templateresolver.*

@Configuration
class TemplatingConfiguration {
    @Bean
    fun templateResolver() = ClassLoaderTemplateResolver().apply {
        suffix = ".html"
        templateMode = "HTML5"
    }

    @Bean
    fun templateEngine(templateResolver: TemplateResolver) = TemplateEngine().apply {
        setTemplateResolver(templateResolver)
    }
}