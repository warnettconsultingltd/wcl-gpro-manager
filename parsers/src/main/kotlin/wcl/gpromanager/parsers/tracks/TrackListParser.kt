package wcl.gpromanager.parsers.tracks

import org.jsoup.Jsoup
import wcl.gpromanager.parsers.tracks.entities.TrackHeader

private const val TRACK_HEADER_ATTRIBUTES_SELECTOR = "table > tbody > tr > td > a"

class TrackListParser {
    fun parse(htmlText: String): List<TrackHeader> {
        val trackHeaders = ArrayList<TrackHeader>()

        val doc = Jsoup.parse(htmlText)
        val elements = doc.select(TRACK_HEADER_ATTRIBUTES_SELECTOR)

        for (element in elements) {
            val trackIdAttribute = element.attr("href")
            val equalPosition = trackIdAttribute.indexOf("=") + 1
            val trackId = trackIdAttribute.substring(equalPosition).toInt()
            trackHeaders.add(TrackHeader(trackId, element.html()))
        }

        return trackHeaders
    }
}
