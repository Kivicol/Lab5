package src.data;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class Route extends Overall implements Validation, Serializable {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле может быть null
    private float distance; //Значение поля должно быть больше 1

    public Route(long id, String name, Coordinates coordinates, ZonedDateTime creationDate, Location from, Location to, float distance){
        this.id = id;
        this.name =  name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    @Override
    public boolean validate() {
        if (id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null || !coordinates.validate()) return false;
        if (creationDate == null) return false;
        if (from == null) return false;
        if (to == null) return false;
        if (distance <= 1) return false;
        return true;
    }


    @Override
    public String toString() {
        return "aboba{\"id\": " + id + ", " +
                "\"name\": \"" + name + "\", " +
                "\"coordinates\": \"" + coordinates + "\", " +
                "\"creationDate\": \"" + creationDate + "\", " +
                "\"from\": " + from + "\", " +
                "\"to\": " + to + "\", " +
                "\"distance\": " + distance + "}";
    }

    @Override
    public int getId() {
        return (int) id;
    }

    @Override
    public int compareTo(Overall overall) {
        return (int)(this.id - overall.getId());
    }
}
