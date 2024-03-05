package wcl.gpromanager.parsers.utils

class FloatValueRetriever : ValueRetriever<Float> {
    override fun convert(value: String): Float {
        return value.toFloat()
    }
}
