package wcl.gpromanager.parsers.testutils

import org.apache.commons.io.IOUtils
import org.junit.jupiter.api.Assertions.*
import java.io.IOException

object HtmlFileLoader {
    @JvmStatic
    fun loadHtmlFile(htmlFileName: String): String {
        var fileContent = ""
        try {
            HtmlFileLoader::class.java.getResourceAsStream(htmlFileName).use { inputStream ->
                fileContent = IOUtils.toString(inputStream, "UTF-8")
            }
        } catch (e: IOException) {
            fail<Any>("Error loading file $htmlFileName")
        }
        return fileContent
    }
}
