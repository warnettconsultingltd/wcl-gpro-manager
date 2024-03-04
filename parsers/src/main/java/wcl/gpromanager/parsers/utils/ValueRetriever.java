package wcl.gpromanager.parsers.utils;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.function.Function;

public interface ValueRetriever<T> {

    default T extractValue(Elements elements, String selector){
        return extractValue(elements, selector, s -> s);
    }

    default T extractValue(Document document, String selector) {
        return extractValue(document.children(), selector);
    }

    default T extractValue(Elements elements, String selector, String attributeName){
        return extractValue(elements, selector, attributeName, s -> s);
    }

    default T extractValue(Document document, String selector, String attributeName) {
        return extractValue(document.children(), selector, attributeName);
    }

    default T extractValue(Elements elements, String selector, Function<String, String> transformer) {
        final var value = getValue(elements, selector);
        final var transformedAttributeValue = transform(value, transformer);
        return convert(transformedAttributeValue);
    }

    default T extractValue(Elements elements, String selector, String attributeName, Function<String, String> transformer) {
        final var value = getAttributeValue(elements, selector, attributeName);
        final var transformedAttributeValue = transform(value, transformer);
        return convert(transformedAttributeValue);
    }

    private String getValue(Elements elements, String selector) {
        return elements.select(selector).text();
    }

    private String getAttributeValue(Elements elements, String selector, String attributeName) {
        return elements.select(selector).attr(attributeName);
    }

    private String transform(String value, Function<String, String> transformation) {
        return transformation.apply(value);
    }

    T convert(String attributeValue);
}
