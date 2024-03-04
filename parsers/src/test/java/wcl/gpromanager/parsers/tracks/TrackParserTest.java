package wcl.gpromanager.parsers.tracks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wcl.gpromanager.parsers.testutils.HtmlFileLoader;
import wcl.gpromanager.parsers.tracks.entities.Track;
import wcl.gpromanager.parsers.utils.FloatValueRetriever;
import wcl.gpromanager.parsers.utils.IntegerValueRetriever;
import wcl.gpromanager.parsers.utils.StringValueRetriever;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
// @TODO COnvert to use AssertJ?
public class TrackParserTest {
    private static final String TRACK_TEST_HTML_FILE
            = "/htmlpages/Tracks/Track/Track information - Buenos Aires - Grand Prix Racing Online 26-0-24.html";

    private TrackParser testParser;
    private Track testTrack;

    @BeforeEach
    public void setupTestParser() {
        testParser = new TrackParser(new FloatValueRetriever(), new IntegerValueRetriever(), new StringValueRetriever());
        testTrack = testParser.parse(2, HtmlFileLoader.loadHtmlFile(TRACK_TEST_HTML_FILE));
    }

    @Test
    public void whenTrackListPageParsed_thenIdCorrectlyExtracted() {
        assertEquals(2, testTrack.id());
    }

    @Test
    public void whenTrackListPageParsed_thenTrackNameCorrectlyExtracted() {
        assertEquals("Buenos Aires", testTrack.trackName());
    }

    @Test
    public void whenTrackListPageParsed_thenLocationCorrectlyExtracted() {
        assertEquals("Argentina", testTrack.location());
    }


    @Test
    public void whenTrackListPageParsed_thenImageFileNameCorrectlyExtracted() {
        assertEquals("track_buenos_arg.gif", testTrack.imageFileName());
    }
    @Test
    public void whenTrackListPageParsed_thenRaceDistanceCorrectlyExtracted() {
        assertEquals(306.6, testTrack.raceDistance(), 0.1);
    }

    @Test
    public void whenTrackListPageParsed_thenLapsCorrectlyExtracted() {
        assertEquals(72, testTrack.laps());
    }

    @Test
    public void whenTrackListPageParsed_thenLapDistanceCorrectlyExtracted() {
        assertEquals(4.258, testTrack.lapDistance(), 0.001);
    }

    @Test
    public void whenTrackListPageParsed_thenAverageSpeedCorrectlyExtracted() {
        assertEquals(189.63, testTrack.averageSpeed(), 0.01);
    }

    @Test
    public void whenTrackListPageParsed_thenCornersCorrectlyExtracted() {
        assertEquals(16, testTrack.corners());
    }

    @Test
    public void whenTrackListPageParsed_thenPitLaneTimeCorrectlyExtracted() {
        assertEquals(19.5, testTrack.pitlaneTime(), 0.01);
    }

    @Test
    public void whenTrackListPageParsed_thenPowerCorrectlyExtracted() {
        assertEquals(12, testTrack.power());
    }

    @Test
    public void whenTrackListPageParsed_thenHandlingCorrectlyExtracted() {
        assertEquals(11, testTrack.handling());
    }

    @Test
    public void whenTrackListPageParsed_thenAccelerationCorrectlyExtracted() {
        assertEquals(9, testTrack.acceleration());
    }

    @Test
    public void whenTrackListPageParsed_thenDownforceCorrectlyExtracted() {
        assertEquals("High", testTrack.downforce());
    }

    @Test
    public void whenTrackListPageParsed_thenOvertakingCorrectlyExtracted() {
        assertEquals("Very hard", testTrack.overtaking());
    }

    @Test
    public void whenTrackListPageParsed_thenSuspensionRigidityCorrectlyExtracted() {
        assertEquals("Hard", testTrack.suspensionRigidity());
    }

    @Test
    public void whenTrackListPageParsed_thenFuelConsumptionCorrectlyExtracted() {
        assertEquals("Very low", testTrack.fuelConsumption());
    }

    @Test
    public void whenTrackListPageParsed_thenTyreWearCorrectlyExtracted() {
        assertEquals("High", testTrack.tyreWear());
    }

    @Test
    public void whenTrackListPageParsed_thenGripLevelCorrectlyExtracted() {
        assertEquals("Normal", testTrack.gripLevel());
    }
}