package src.command.commands;

import src.command.Receiver;
import src.command.Utility.RouteBuilder;
import src.command.exceptions.InvalidDataException;
import src.data.Route;

import java.util.LinkedList;

public class AddCom implements BasicCommand{
    @Override
    public void execute(String[] args){
        try {
            System.out.println("Adding object to Route");
            Route route = null;
            Receiver.add(new RouteBuilder().create());
            System.out.println("Object added successfully");
        } catch (InvalidDataException e) {
            System.err.println("There is a mistake in the provided data, try again");;
        }
    }

    @Override
    public String getName() {
        return "Add";
    }

    @Override
    public String getDescription() {
        return "adds an element to the collection";
    }
}