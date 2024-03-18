package src.command;

import src.command.Utility.IdGenerate;
import src.command.exceptions.InvalidDataException;
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
    public static void updateById(long id, Route route) throws InvalidDataException, NoSuchElementException {
        Route old = getById(id);
        table.remove(old);
        route.setId(id);
        table.add(route);
    }

    public static Route getById(long id) {
        for (Route route : table) {
            if (id == route.getId()) {
                return route;
            }
        }
        return null;
    }

    public static void remove(long id) throws NoElementException {
        for (Route route : table) {
            if (table == null || !(Receiver.table.contains(getById(id)))) {
                throw new NoElementException(id);
            } else {
                IdGenerate.remove((int) id);
                table.remove(route);
            }
        }
    }

    public static LinkedList<Route> getTable() {
        return table;
    }

    public static void clear() throws NoElementException{
        table.clear();
    }

}
