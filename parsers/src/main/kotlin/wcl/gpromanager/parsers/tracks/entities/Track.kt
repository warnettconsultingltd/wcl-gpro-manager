package wcl.gpromanager.parsers.tracks.entities

data class Track(
    val id: Int,
    val trackName: String,
    val imageFileName: String,
    val location: String,
    val raceDistance: Float,
    val laps: Int,
    val lapDistance: Float,
    val averageSpeed: Float,
    val corners: Int,
    val pitlaneTime: Float,
    val power: Int,
    val handling: Int,
    val acceleration: Int,
    val downforce: String,
    val overtaking: String,
    val suspensionRigidity: String,
    val fuelConsumption: String,
    val tyreWear: String,
    val gripLevel: String
)

