package wcl.gpromanager.parsers.utils;

public class StringValueRetriever implements ValueRetriever<String> {
    @Override
    public String convert(String attributeValue) {
        return attributeValue;
    }
}
