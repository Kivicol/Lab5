package src.command.commands;

import src.command.Receiver;
import src.command.exceptions.NoElementException;

public class RemoveByIdCom implements BasicCommand{


    @Override
    public void execute(String[] args) {
        try {
            long id = Long.parseLong(args[1]);
            Receiver.remove(id);
            System.out.println("Object successfully removed");
        } catch (NoElementException e) {
            System.err.println("There's no object with this id");;
        }
    }

    @Override
    public String getName() {
        return "RemoveById";
    }

    @Override
    public String getDescription() {
        return "remove the object by it's id";
    }
}
