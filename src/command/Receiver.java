package src.command;

import src.data.Coordinates;

import java.time.LocalDate;
import java.util.LinkedList;

public class Receiver {
    private static LinkedList<Coordinates> table = new LinkedList<>();
    private static LocalDate date;

    public Receiver() {
        table = new LinkedList<>();
        date = LocalDate.now();
    }
    public static LocalDate getInitDate() {
        return date;
    }
    public static void add(Coordinates coordinates) {
        if (table == null) {
            table = new LinkedList<>();
        }
        table.add(coordinates);
    }

    public static void remove(Coordinates coordinates) {
        table.remove(coordinates);
    }
}
