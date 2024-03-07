package wcl.gpromanager.parsers.tracks

import org.junit.jupiter.api.*
import wcl.gpromanager.parsers.testutils.HtmlFileLoader.loadHtmlFile
import wcl.gpromanager.parsers.utils.*
import org.assertj.core.api.Assertions.*
import wcl.gpromanager.entities.track.Track

class TrackParserTest {
    private lateinit var testParser: TrackParser
    private lateinit var testTrack: Track

    @BeforeEach
    fun setupTestParser() {
        testParser = TrackParser(FloatValueRetriever(), IntegerValueRetriever(), StringValueRetriever())
        testTrack = testParser.parse(2, loadHtmlFile(TRACK_TEST_HTML_FILE))
    }

    @Test
    fun whenTrackListPageParsed_thenIdCorrectlyExtracted() {
        assertThat(testTrack.id).isEqualTo(2)
    }

    @Test
    fun whenTrackListPageParsed_thenTrackNameCorrectlyExtracted() {
        assertThat(testTrack.trackName).isEqualTo("Buenos Aires")
    }

    @Test
    fun whenTrackListPageParsed_thenLocationCorrectlyExtracted() {
        assertThat(testTrack.location).isEqualTo("Argentina")
    }

    @Test
    fun whenTrackListPageParsed_thenImageFileNameCorrectlyExtracted() {
        assertThat(testTrack.imageFileName).isEqualTo("track_buenos_arg.gif")
    }

    @Test
    fun whenTrackListPageParsed_thenRaceDistanceCorrectlyExtracted() {
        assertThat(testTrack.raceDistance).isEqualTo(306.6f, withPrecision(0.1f))
    }

    @Test
    fun whenTrackListPageParsed_thenLapsCorrectlyExtracted() {
        assertThat(testTrack.laps).isEqualTo(72)
    }

    @Test
    fun whenTrackListPageParsed_thenLapDistanceCorrectlyExtracted() {
        assertThat(testTrack.lapDistance).isEqualTo(4.258f, withPrecision(0.001f))
    }

    @Test
    fun whenTrackListPageParsed_thenAverageSpeedCorrectlyExtracted() {
        assertThat(testTrack.averageSpeed).isEqualTo(189.63f, withPrecision(0.01f))
    }

    @Test
    fun whenTrackListPageParsed_thenCornersCorrectlyExtracted() {
        assertThat(testTrack.corners).isEqualTo(16)
    }

    @Test
    fun whenTrackListPageParsed_thenPitLaneTimeCorrectlyExtracted() {
        assertThat(testTrack.pitlaneTime).isEqualTo(19.5f, withPrecision(0.1f))
    }

    @Test
    fun whenTrackListPageParsed_thenPowerCorrectlyExtracted() {
        assertThat(testTrack.power).isEqualTo(12)
    }

    @Test
    fun whenTrackListPageParsed_thenHandlingCorrectlyExtracted() {
        assertThat(testTrack.handling).isEqualTo(11)
    }

    @Test
    fun whenTrackListPageParsed_thenAccelerationCorrectlyExtracted() {
        assertThat(testTrack.acceleration).isEqualTo(9)
    }

    @Test
    fun whenTrackListPageParsed_thenDownforceCorrectlyExtracted() {
        assertThat(testTrack.downforce).isEqualTo("High")
    }

    @Test
    fun whenTrackListPageParsed_thenOvertakingCorrectlyExtracted() {
        assertThat(testTrack.overtaking).isEqualTo("Very hard")
    }

    @Test
    fun whenTrackListPageParsed_thenSuspensionRigidityCorrectlyExtracted() {
        assertThat(testTrack.suspensionRigidity).isEqualTo("Hard")
    }

    @Test
    fun whenTrackListPageParsed_thenFuelConsumptionCorrectlyExtracted() {
        assertThat(testTrack.fuelConsumption).isEqualTo("Very low")
    }

    @Test
    fun whenTrackListPageParsed_thenTyreWearCorrectlyExtracted() {
        assertThat(testTrack.tyreWear).isEqualTo("High")
    }

    @Test
    fun whenTrackListPageParsed_thenGripLevelCorrectlyExtracted() {
        assertThat(testTrack.gripLevel).isEqualTo("Normal")
    }

    companion object {
        private const val TRACK_TEST_HTML_FILE = "/htmlpages/Tracks/Track/Track information - Buenos Aires - Grand Prix Racing Online 26-0-24.html"
    }
}