package src.command.commands;

import src.command.Receiver;
import src.command.exceptions.NoElementException;

import javax.sound.midi.Soundbank;

public class ClearCom implements BasicCommand{

    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            if (!(Receiver.getTable().isEmpty())){
                System.out.println("Clearing collection...");
                Receiver.clear();
                System.out.println("Collection cleared");
            } else {
                System.err.println("Collection is empty, why would you clear it from non-existent objects");
            }
        }else{
            System.out.println("You have inputted the command incorrectly");
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
