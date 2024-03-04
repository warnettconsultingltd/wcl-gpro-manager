package wcl.gpromanager.parsers.utils;


public final class IntegerValueRetriever implements ValueRetriever<Integer> {
    @Override
    public Integer convert(String attributeValue) {
        return Integer.parseInt(attributeValue);
    }
}
