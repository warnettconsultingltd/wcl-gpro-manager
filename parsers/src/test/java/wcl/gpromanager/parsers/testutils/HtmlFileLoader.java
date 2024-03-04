package wcl.gpromanager.parsers.testutils;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.fail;

public class HtmlFileLoader {
    private HtmlFileLoader() {}

    public static String loadHtmlFile(final String htmlFileName)  {
        String fileContent = "";
        try (var inputStream = HtmlFileLoader.class.getResourceAsStream(htmlFileName)) {
            fileContent = IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException e) {
            fail("Error loading file " + htmlFileName);
        }
        return fileContent;

    }
}
