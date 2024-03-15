package src.command.commands;

import src.command.Receiver;
import src.command.Utility.RouteBuilder;
import src.command.exceptions.InvalidDataException;
import src.command.exceptions.NoElementException;

import java.util.Arrays;

public class UpdateById implements BasicCommand{
    private final Receiver receiver;
    public UpdateById(Receiver a){
        this.receiver=a;
    }
    public void execute(String[] args){
        try{
            long id = Long.parseLong(Arrays.toString(args));
            receiver.updateById(id, new RouteBuilder().create());
            System.out.println("Object successfully added");
        } catch (InvalidDataException a){
            System.out.println("Data provided is wrong, try again");
        } catch (NumberFormatException e){
            System.err.println("Input the \"long\"-type number");
        }
    }


    @Override
    public String getName() {
        return "UpdateById";
    }

    @Override
    public String getDescription() {
        return "update the object's id";
    }
}
