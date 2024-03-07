package src.command;

import src.command.Utility.IdGenerate;
import src.data.Route;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.LinkedList;

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
    public static void add(Integer id,Route route) {
        if (table == null) {
            table = new LinkedList<>();
        }
        table.add(id, route);
        IdGenerate.add(route.getId());
    }

    public static void remove(Route route) {
        if (table == null || !Receiver.table.contains(route)) {
            System.exit(0);
        } else {
            IdGenerate.remove(route.getId());
            table.remove(route);
        }
    }

    public static LinkedList<Route> getTable() {
        return table;
    }

}
