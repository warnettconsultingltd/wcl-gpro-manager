package wcl.gpromanager.parsers.utils

import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.util.function.Function

interface ValueRetriever<T> {
    fun extractValue(document: Document, selector: String): T {
        return extractValue(document.children(), selector)
    }

    fun extractValue(document: Document, selector: String, attributeName: String): T {
        return extractValue(document.children(), selector, attributeName)
    }

    fun extractValue(elements: Elements, selector: String, transformer: Function<String, String> = Function { s: String -> s }): T {
        val value = getValue(elements, selector)
        val transformedAttributeValue = transform(value, transformer)
        return convert(transformedAttributeValue)
    }

    fun extractValue(elements: Elements, selector: String, attributeName: String, transformer: Function<String, String> = Function { s: String -> s }): T {
        val value = getAttributeValue(elements, selector, attributeName)
        val transformedAttributeValue = transform(value, transformer)
        return convert(transformedAttributeValue)
    }

    private fun getValue(elements: Elements, selector: String): String {
        return elements.select(selector).text()
    }

    private fun getAttributeValue(elements: Elements, selector: String, attributeName: String): String {
        return elements.select(selector).attr(attributeName)
    }

    private fun transform(value: String, transformation: Function<String, String>): String {
        return transformation.apply(value)
    }

    fun convert(value: String): T
}
