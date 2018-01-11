package nl.sourcelabs.invoicingservice.pdf

import org.springframework.stereotype.*
import org.thymeleaf.*
import org.thymeleaf.context.*
import org.xhtmlrenderer.pdf.*
import java.io.*

@Component
class TemplatePdfExporter(val engine: TemplateEngine) {

    fun exportTemplate(templateName: String, context: IContext, outputStream: OutputStream) {
        val renderer = ITextRenderer()
        renderer.setDocumentFromString(engine.process("templates/$templateName", context))
        renderer.fontResolver.addFont("templates/font/Raleway-Regular.ttf", true)
        renderer.layout()
        renderer.createPDF(outputStream)
        outputStream.close()
    }
}