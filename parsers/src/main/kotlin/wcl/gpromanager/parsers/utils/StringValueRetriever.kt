package wcl.gpromanager.parsers.utils

class StringValueRetriever : ValueRetriever<String> {
    override fun convert(value: String): String {
        return value
    }
}
