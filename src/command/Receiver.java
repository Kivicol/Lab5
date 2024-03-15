package src.command;

import src.command.Utility.IdGenerate;
import src.command.exceptions.NoElementException;
import src.data.Route;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Receiver {
    private static LinkedList<Route> table = new LinkedList<>();
    private static ZonedDateTime date;

    public Receiver() {
        table = new LinkedList<>();
        date = ZonedDateTime.now();
        new IdGenerate();
    }
    public static ZonedDateTime getInitDate() {
        return date;
    }
    public static void add(Integer id, Route route) {
        if (table == null) {
            table = new LinkedList<>();
        }
        table.add(id, route);
        IdGenerate.add(route.getId());
    }

    public static void add(Route route) {
        if (table == null) {
            table = new LinkedList<>();
        }
        table.add(route);
        IdGenerate.add(route.getId());
    }

    public static void remove(int id) throws NoElementException {
        if (table == null || !Receiver.table.contains(id)) {
            throw new NoElementException(id);
        } else {
            IdGenerate.remove(id);
            table.remove(id);
        }
    }

    public static LinkedList<Route> getTable() {
        return table;
    }

}
