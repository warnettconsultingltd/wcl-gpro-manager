package wcl.gpromanager.parsers.tracks.entities;

import lombok.Value;
import lombok.experimental.Accessors;

@Value
@Accessors(fluent=true)
public class Track {
    private int id;
    private String trackName;
    private String imageFileName;
    private String location;
    private float raceDistance;
    private int laps;
    private float lapDistance;
    private float averageSpeed;
    private int corners;
    private float pitlaneTime;
    private int power;
    private int handling;
    private int acceleration;
    private String downforce;
    private String overtaking;
    private String suspensionRigidity;
    private String fuelConsumption;
    private String tyreWear;
    private String gripLevel;
}
