package wcl.gpromanager.parsers.tracks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import wcl.gpromanager.parsers.tracks.entities.Track;
import wcl.gpromanager.parsers.utils.*;

import java.util.function.Function;

public class TrackParser {

    private static final String TRACK_ATTRIBUTES_SELECTOR = "table.paddedsmall > tbody";
    private static final String TRACK_IMAGE_SELECTOR = "table.styled > tbody > tr:eq(1) > td:eq(0) > img";
    private static final String TRACK_IMAGE_NAME_SELECTOR = "src";
    private static final String TRACK_NAME_SELECTOR = "h1.block";
    private static final String LOCATION_SELECTOR = "tr:eq(0) > td:eq(1)";
    private static final String POWER_SELECTOR = "tr:eq(0) > td:eq(3)";
    private static final String TITLE_SELECTOR = "title";
    private static final String HANDLING_SELECTOR = "tr:eq(1) > td:eq(3)";
    private static final String RACE_DISTANCE_SELECTOR = "tr:eq(2) > td:eq(1)";
    private static final String ACCELERATION_SELECTOR = "tr:eq(2) > td:eq(3)";
    private static final String LAPS_SELECTOR = "tr:eq(3) > td:eq(1)";
    private static final String DOWNFORCE_SELECTOR = "tr:eq(3) > td:eq(3)";
    private static final String LAP_DISTANCE_SELECTOR = "tr:eq(4) > td:eq(1)";
    private static final String OVERTAKING_SELECTOR = "tr:eq(4) > td:eq(3)";
    private static final String AVERAGE_SPEED_SELECTOR = "tr:eq(5) > td:eq(1)";
    private static final String SUSPENSION_RIGIDITY_SELECTOR = "tr:eq(5) > td:eq(3)";
    private static final String FUEL_CONSUMPTION_SELECTOR = "tr:eq(6) > td:eq(3)";
    private static final String CORNERS_SELECTOR = "tr:eq(7) > td:eq(1)";
    private static final String TYRE_WEAR_SELECTOR = "tr:eq(7) > td:eq(3)";
    private static final String PITLANE_TIME_SELECTOR = "tr:eq(8) > td:eq(1)";
    private static final String GRIP_LEVEL_SELECTOR = "tr:eq(8) > td:eq(3)";
    private static final Function<String, String> REMOVE_KM = s -> s.replaceAll("km", "");
    private static final Function<String, String> REMOVE_KM_PER_HOUR = s -> s.replaceAll("km/h", "");
    private static final Function<String, String> REMOVE_S = s -> s.replaceAll("s", "");

    private final ValueRetriever<Float> floatRetriever;
    private final ValueRetriever<Integer> integerRetriever;
    private final ValueRetriever<String> stringRetriever;

    public TrackParser(final ValueRetriever<Float> floatRetriever,
                       final ValueRetriever<Integer> integerRetriever,
                       final ValueRetriever<String> stringRetriever) {
        this.floatRetriever = floatRetriever;
        this.integerRetriever = integerRetriever;
        this.stringRetriever = stringRetriever;
    }

    public Track parse(int trackId, String htmlText) {
        final var doc = getDocument(htmlText);
        final var elements = doc.select(TRACK_ATTRIBUTES_SELECTOR);


// @TODO rename Elements to "trackAttributeElements"

        return new Track(trackId,
                stringRetriever.extractValue(doc, TRACK_NAME_SELECTOR),
                extractTrackImageFileName(doc),
                stringRetriever.extractValue(elements, LOCATION_SELECTOR),
                floatRetriever.extractValue(elements, RACE_DISTANCE_SELECTOR, REMOVE_KM),
                integerRetriever.extractValue(elements, LAPS_SELECTOR),
                floatRetriever.extractValue(elements, LAP_DISTANCE_SELECTOR, REMOVE_KM),
                floatRetriever.extractValue(elements, AVERAGE_SPEED_SELECTOR, REMOVE_KM_PER_HOUR),
                integerRetriever.extractValue(elements,CORNERS_SELECTOR),
                floatRetriever.extractValue(elements, PITLANE_TIME_SELECTOR, REMOVE_S),
                integerRetriever.extractValue(elements, POWER_SELECTOR, TITLE_SELECTOR),
                integerRetriever.extractValue(elements, HANDLING_SELECTOR, TITLE_SELECTOR),
                integerRetriever.extractValue(elements, ACCELERATION_SELECTOR, TITLE_SELECTOR),
                stringRetriever.extractValue(elements, DOWNFORCE_SELECTOR),
                stringRetriever.extractValue(elements, OVERTAKING_SELECTOR),
                stringRetriever.extractValue(elements, SUSPENSION_RIGIDITY_SELECTOR),
                stringRetriever.extractValue(elements, FUEL_CONSUMPTION_SELECTOR),
                stringRetriever.extractValue(elements, TYRE_WEAR_SELECTOR),
                stringRetriever.extractValue(elements, GRIP_LEVEL_SELECTOR));
    }

    private static String extractTrackImageFileName(Document doc) {
        final var src = doc.select(TRACK_IMAGE_SELECTOR).attr(TRACK_IMAGE_NAME_SELECTOR);
        return src.substring(src.lastIndexOf("/") + 1);
    }

    private static Document getDocument(String htmlText) {
        final var doc = Jsoup.parse(htmlText);
        return doc;
    }


}
