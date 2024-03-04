package wcl.gpromanager.parsers.tracks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import wcl.gpromanager.parsers.tracks.entities.TrackHeader;

import java.util.ArrayList;
import java.util.List;

public class TrackListParser {
//    <a href="TrackDetails.asp?id=2">Buenos Aires</a>
//
//    Selector: #contentinner > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > a
//    Full XPath: /html/body/div/div/div[2]/div[2]/div[2]/div/table/tbody/tr[2]/td[1]/a
//
    public List<TrackHeader> parse(String htmlText) {
        final var trackHeaders = new ArrayList<TrackHeader>();

        final var doc = Jsoup.parse(htmlText);
//        final var elements = doc.select("#contentinner > div > table > tbody > tr:nth-child(*) > td:nth-child(1) > a");
//        System.out.println("Id = "+ elements.attr("id"));

//        "table > tbody > tr[2] > td[1] > a"
        final var elements = doc.select("table > tbody > tr > td > a");
//        final var trElements = elements.nextAll("tr");

//        final var allARefs = elements.nextAll("td[1]/a");

        for (Element element: elements) {
//            System.out.println("A Element : " + element.html() + " : attr " + element.attr("href"));

            final var trackIdAttribute = element.attr("href");
            final int equalPosition = trackIdAttribute.indexOf("=") + 1;
            final int trackId = Integer.parseInt(trackIdAttribute.substring(equalPosition));
            trackHeaders.add(new TrackHeader(trackId, element.html()));
        }

        return trackHeaders;
    }
}
