package src.command.commands;

import src.command.Receiver;

public class InfoCom implements BasicCommand{
    @Override
    public void execute(String[] args){
        System.out.println("Data -- " + Receiver.getTable().getClass().getName());
        System.out.println("Count of --" + Receiver.getTable());
        System.out.println("Init date -- " + Receiver.getInitDate());
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "information about the program";
    }
}
