package wcl.gpromanager.parsers.tracks

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import wcl.gpromanager.entities.track.Track
import wcl.gpromanager.parsers.utils.ValueRetriever
import java.util.function.Function

class TrackParser(private val floatRetriever: ValueRetriever<Float>,
                  private val integerRetriever: ValueRetriever<Int>,
                  private val stringRetriever: ValueRetriever<String>) {
    fun parse(trackId: Int, htmlText: String): Track {
        val doc = getDocument(htmlText)
        val elements = doc.select(TRACK_ATTRIBUTES_SELECTOR)


        // @TODO rename Elements to "trackAttributeElements"
        return Track(trackId,
                stringRetriever.extractValue(doc, TRACK_NAME_SELECTOR),
                extractTrackImageFileName(doc),
                stringRetriever.extractValue(elements, LOCATION_SELECTOR),
                floatRetriever.extractValue(elements, RACE_DISTANCE_SELECTOR, REMOVE_KM),
                integerRetriever.extractValue(elements, LAPS_SELECTOR),
                floatRetriever.extractValue(elements, LAP_DISTANCE_SELECTOR, REMOVE_KM),
                floatRetriever.extractValue(elements, AVERAGE_SPEED_SELECTOR, REMOVE_KM_PER_HOUR),
                integerRetriever.extractValue(elements, CORNERS_SELECTOR),
                floatRetriever.extractValue(elements, PITLANE_TIME_SELECTOR, REMOVE_S),
                integerRetriever.extractValue(elements, POWER_SELECTOR, TITLE_SELECTOR),
                integerRetriever.extractValue(elements, HANDLING_SELECTOR, TITLE_SELECTOR),
                integerRetriever.extractValue(elements, ACCELERATION_SELECTOR, TITLE_SELECTOR),
                stringRetriever.extractValue(elements, DOWNFORCE_SELECTOR),
                stringRetriever.extractValue(elements, OVERTAKING_SELECTOR),
                stringRetriever.extractValue(elements, SUSPENSION_RIGIDITY_SELECTOR),
                stringRetriever.extractValue(elements, FUEL_CONSUMPTION_SELECTOR),
                stringRetriever.extractValue(elements, TYRE_WEAR_SELECTOR),
                stringRetriever.extractValue(elements, GRIP_LEVEL_SELECTOR))
    }

    companion object {
        private const val TRACK_ATTRIBUTES_SELECTOR = "table.paddedsmall > tbody"
        private const val TRACK_IMAGE_SELECTOR = "table.styled > tbody > tr:eq(1) > td:eq(0) > img"
        private const val TRACK_IMAGE_NAME_SELECTOR = "src"
        private const val TRACK_NAME_SELECTOR = "h1.block"
        private const val LOCATION_SELECTOR = "tr:eq(0) > td:eq(1)"
        private const val POWER_SELECTOR = "tr:eq(0) > td:eq(3)"
        private const val TITLE_SELECTOR = "title"
        private const val HANDLING_SELECTOR = "tr:eq(1) > td:eq(3)"
        private const val RACE_DISTANCE_SELECTOR = "tr:eq(2) > td:eq(1)"
        private const val ACCELERATION_SELECTOR = "tr:eq(2) > td:eq(3)"
        private const val LAPS_SELECTOR = "tr:eq(3) > td:eq(1)"
        private const val DOWNFORCE_SELECTOR = "tr:eq(3) > td:eq(3)"
        private const val LAP_DISTANCE_SELECTOR = "tr:eq(4) > td:eq(1)"
        private const val OVERTAKING_SELECTOR = "tr:eq(4) > td:eq(3)"
        private const val AVERAGE_SPEED_SELECTOR = "tr:eq(5) > td:eq(1)"
        private const val SUSPENSION_RIGIDITY_SELECTOR = "tr:eq(5) > td:eq(3)"
        private const val FUEL_CONSUMPTION_SELECTOR = "tr:eq(6) > td:eq(3)"
        private const val CORNERS_SELECTOR = "tr:eq(7) > td:eq(1)"
        private const val TYRE_WEAR_SELECTOR = "tr:eq(7) > td:eq(3)"
        private const val PITLANE_TIME_SELECTOR = "tr:eq(8) > td:eq(1)"
        private const val GRIP_LEVEL_SELECTOR = "tr:eq(8) > td:eq(3)"
        private val REMOVE_KM = Function { s: String -> s.replace("km".toRegex(), "") }
        private val REMOVE_KM_PER_HOUR = Function { s: String -> s.replace("km/h".toRegex(), "") }
        private val REMOVE_S = Function { s: String-> s.replace("s".toRegex(), "") }

        private fun extractTrackImageFileName(doc: Document): String {
            val src = doc.select(TRACK_IMAGE_SELECTOR).attr(TRACK_IMAGE_NAME_SELECTOR)
            return src.substring(src.lastIndexOf("/") + 1)
        }

        private fun getDocument(htmlText: String): Document {
            return Jsoup.parse(htmlText)
        }
    }
}
