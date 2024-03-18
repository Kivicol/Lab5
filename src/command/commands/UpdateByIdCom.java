package src.command.commands;

import src.command.Receiver;
import src.command.Utility.RouteBuilder;
import src.command.exceptions.InvalidDataException;

import java.util.Arrays;

public class UpdateByIdCom implements BasicCommand{
//    private final Receiver receiver;
//    public UpdateByIdCom(Receiver receiver){
//        this.receiver=receiver;
//    }

    @Override
    public void execute(String[] args){
        try{
            long id = Long.parseLong(args[1]);
            Receiver.updateById(id , new RouteBuilder().create());
            System.out.println("Object successfully added");
        } catch (InvalidDataException a){
            System.out.println("Data provided is wrong, try again");
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
