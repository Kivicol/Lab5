package src.command.commands;

import src.command.Receiver;
import src.command.exceptions.NoElementException;

public class ClearCom implements BasicCommand{

    @Override
    public void execute(String[] args) {
        try {
            System.out.println("Clearing collection...");
            Receiver.clear();
            System.out.println("Collection cleared");
        }catch (NoElementException e){
            System.err.println("Collection is empty,  why would you clear it from non-existent objects...");
        }
    }

    @Override
    public String getName() {
        return "Clear";
    }

    @Override
    public String getDescription() {
        return "clear the collection";
    }
}
