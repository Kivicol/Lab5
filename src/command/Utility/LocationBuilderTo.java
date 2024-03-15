package src.command.Utility;

import src.command.exceptions.InvalidDataException;
import src.data.Location;

public class LocationBuilderTo extends Builder{
    public Location create() throws InvalidDataException {
        return new Location(
                buildInt("Location's \"to\" х value: "), buildLong("Location's \"to\" y value: "), buildString("Location's \"to\" name: "));
    }
}
