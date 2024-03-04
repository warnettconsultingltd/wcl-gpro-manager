package wcl.gpromanager.parsers.tracks;

import org.junit.jupiter.api.*;
import wcl.gpromanager.parsers.testutils.HtmlFileLoader;
import wcl.gpromanager.parsers.tracks.entities.TrackHeader;

import java.util.*;

import static org.junit.Assert.*;

public class TrackListParserTest {
    private static final String TRACKS_LIST_TEST_HTML_FILE
            = "/htmlpages/Tracks/List/Tracks list - Grand Prix Racing Online 26-02-24.html";
    private static final int EXPECTED_NUMBER_OF_TRACKS = 64;
    private static final int EXPECTED_TRACK_ID = 3;
    private static final String EXPECTED_TRACK_NAME = "Imola";

    private TrackListParser testParser;
    private List<TrackHeader> testTrackHeaders;

    @BeforeEach
    public void setupTestParser() {
        testParser = new TrackListParser();
        testTrackHeaders = new ArrayList<>();
        testTrackHeaders = testParser.parse(HtmlFileLoader.loadHtmlFile(TRACKS_LIST_TEST_HTML_FILE));
    }

    @Test
    public void whenTrackListPageParsed_thenCorrectNumberOfTrackHeadersExtracted() {
        assertEquals(EXPECTED_NUMBER_OF_TRACKS, testTrackHeaders.size());
    }

    @Test
    public void whenTrackListPageParsed_thenASpecficTrackShouldBeExtracted() {
        assertTrue(testTrackHeaders.contains(new TrackHeader(EXPECTED_TRACK_ID, EXPECTED_TRACK_NAME)));
    }
}
