package wcl.gpromanager.parsers.tracks.entities;

import lombok.Value;
import lombok.experimental.Accessors;
@Value
@Accessors(fluent=true)
public class TrackHeader {
    private int id;
    private String trackName;
}
