package src.command.commands;

import src.command.Invoker;

import java.util.LinkedHashMap;

public class HelpCom implements BasicCommand{
    @Override
    public void execute(String[] args){
        Invoker invoker = new Invoker();
        LinkedHashMap<String, BasicCommand> commandList = Invoker.getCommandList();
        for (String name: commandList.keySet()){
            BasicCommand command = commandList.get(name);
            System.out.println(command.getName() + " - " + command.getDescription());
        }
    }

    @Override
    public String getName() {
        return "Help";
    }

    @Override
    public String getDescription() {
        return "shows all available commands";
    }
}
