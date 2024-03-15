package src.command.commands;

import src.command.Receiver;
import src.data.Route;

public class InfoCom implements BasicCommand{
    @Override
    public void execute(String[] args){
        System.out.println("Data -- " + Route.class);
        System.out.println("Count of elements -- " + Receiver.getTable().size());
        System.out.println("Initialization date -- " + Receiver.getInitDate());
    }

    @Override
    public String getName() {
        return "Info";
    }

    @Override
    public String getDescription() {
        return "information about the program";
    }
}
