package src.command;

import src.command.commands.*;

import java.util.LinkedHashMap;

public class Invoker {

    private static LinkedHashMap<String, BasicCommand> commandList;

    public Invoker() {
        commandList = new LinkedHashMap<>();
        commandList.put("help", new HelpCom());
        commandList.put("info", new InfoCom());
        commandList.put("exit", new ExitCom());
        commandList.put("show", new ShowCom());
        commandList.put("add", new AddCom());
        commandList.put("update", new UpdateByIdCom());
        commandList.put("remove", new RemoveByIdCom());
        commandList.put("clear", new ClearCom());
    }


    public void startExecuting(String line) {
        String commandName = line.split(" ")[0];
        BasicCommand command = commandList.get(commandName);
        command.execute(line.split(" "));
    }

    public static LinkedHashMap<String, BasicCommand> getCommandList() {
        return commandList;
    }

}
