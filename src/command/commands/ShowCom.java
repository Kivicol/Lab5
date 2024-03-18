package src.command.commands;

import src.command.Receiver;
import src.data.Route;

import java.util.LinkedList;

public class ShowCom implements BasicCommand{
    @Override
    public void execute(String[] args){
        if(args.length == 1){
            LinkedList<Route> list = Receiver.getTable();
            for (Route x : list) {
                System.out.println(list);
            }
            if (list.isEmpty()) {
                System.out.println("Collection is empty");
            }
        }else{
            System.out.println("You have inputted the command incorrectly");
        }
    }

    @Override
    public String getName() {
        return "Show";
    }

    @Override
    public String getDescription() {
        return "shows all elements in the collection";
    }
}
