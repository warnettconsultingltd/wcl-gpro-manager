package wcl.gpromanager.parsers.utils

class IntegerValueRetriever : ValueRetriever<Int> {
    override fun convert(value: String): Int {
        return value.toInt()
    }
}
