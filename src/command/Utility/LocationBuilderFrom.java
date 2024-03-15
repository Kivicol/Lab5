package src.command.Utility;

import src.command.exceptions.*;
import src.data.Location;

public class LocationBuilderFrom extends Builder{
    public Location create() throws InvalidDataException {
        return new Location(
                buildInt("Location's \"from\" х value: "), buildLong("Location's \"from\" y value: "), buildString("Location's  \"from\" name: "));
    }
}
