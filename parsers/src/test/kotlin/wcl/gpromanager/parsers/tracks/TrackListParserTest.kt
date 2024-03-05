package wcl.gpromanager.parsers.tracks

import org.junit.jupiter.api.*
import wcl.gpromanager.parsers.testutils.HtmlFileLoader.loadHtmlFile
import wcl.gpromanager.parsers.tracks.entities.TrackHeader
import org.assertj.core.api.Assertions.*

class TrackListParserTest {
    private lateinit var testParser: TrackListParser
    private lateinit var testTrackHeaders: List<TrackHeader>

    @BeforeEach
    fun setupTestParser() {
        testParser = TrackListParser()
        testTrackHeaders = ArrayList()
        testTrackHeaders = testParser.parse(loadHtmlFile(TRACKS_LIST_TEST_HTML_FILE))
    }

    @Test
    fun whenTrackListPageParsed_thenCorrectNumberOfTrackHeadersExtracted() {
        assertThat(testTrackHeaders.size.toLong()).isEqualTo(EXPECTED_NUMBER_OF_TRACKS.toLong());
    }

    @Test
    fun whenTrackListPageParsed_thenASpecficTrackShouldBeExtracted() {
        assertThat(testTrackHeaders).contains(TrackHeader(EXPECTED_TRACK_ID, EXPECTED_TRACK_NAME));
    }

    companion object {
        private const val TRACKS_LIST_TEST_HTML_FILE = "/htmlpages/Tracks/List/Tracks list - Grand Prix Racing Online 26-02-24.html"
        private const val EXPECTED_NUMBER_OF_TRACKS = 64
        private const val EXPECTED_TRACK_ID = 3
        private const val EXPECTED_TRACK_NAME = "Imola"
    }
}
