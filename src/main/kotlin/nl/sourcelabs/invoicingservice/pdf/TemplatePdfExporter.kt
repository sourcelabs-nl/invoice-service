package nl.sourcelabs.invoicingservice.pdf

import org.springframework.stereotype.*
import org.thymeleaf.*
import org.thymeleaf.context.*
import org.xhtmlrenderer.pdf.*
import java.io.*

@Component
class TemplatePdfExporter(val engine: TemplateEngine) {

    fun exportTemplate(templateName: String, context: Context, outputStream: OutputStream) {
        val renderer = ITextRenderer()
        val rendered = engine.process("templates/$templateName", context)
        renderer.setDocumentFromString(rendered)
        val resolver = renderer.fontResolver
        renderer.fontResolver.addFont("templates/Raleway-Regular.ttf", true)
        renderer.layout()
        renderer.createPDF(outputStream)
        outputStream.close()
    }
}