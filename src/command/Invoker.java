package src.command;

import src.command.commands.*;

import java.util.LinkedHashMap;

public class Invoker {

    private static LinkedHashMap<String, BasicCommand> commandList;

    public Invoker() {
        commandList = new LinkedHashMap<>();
        commandList.put("help", new HelpCom());
    }

    public void startExecuting(String line) throws Exception {
        String commandName = line.split(" ")[0];

        BasicCommand command = commandList.get(commandName);
        command.execute(line.split(" "));
    }

    public static LinkedHashMap<String, BasicCommand> getCommandList() {
        return commandList;
    }

}
