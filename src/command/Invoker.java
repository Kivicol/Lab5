package src.command;

import src.command.commands.*;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;

public class Invoker {

    private static LinkedHashMap<String, BasicCommand> commandList;
    public static ArrayDeque<BasicCommand> tenComs = new ArrayDeque<>();

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
        commandList.put("shuffle", new ShuffleCom());
        commandList.put("history", new HistoryCom());
        commandList.put("save", new SortCom());
        commandList.put("min_by_name", new MinByNameCom());
        commandList.put("max_by_coordinate", new MaxByCoordinateCom());
        commandList.put("count_less_than_distance", new CountLessThanDistanceCom());
    }


    public void startExecuting(String line) {
        String commandName = line.split(" ")[0];
        BasicCommand command = commandList.get(commandName);
        command.execute(line.split(" "));
        if (!(tenComs == null) && tenComs.size() == 10) {
            tenComs.pop();
            tenComs.addLast(command);
        } else {
            assert tenComs != null;
            tenComs.addFirst(command);
        }
    }

    public static LinkedHashMap<String, BasicCommand> getCommandList() {
        return commandList;
    }

}
