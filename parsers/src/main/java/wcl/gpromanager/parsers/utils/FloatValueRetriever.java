package wcl.gpromanager.parsers.utils;

public class FloatValueRetriever implements ValueRetriever<Float> {
    @Override
    public Float convert(String attributeValue) {
        return Float.parseFloat(attributeValue);
    }
}
