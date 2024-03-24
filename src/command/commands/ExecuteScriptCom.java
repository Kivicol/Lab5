package src.command.commands;

import src.command.Receiver;

public class ExecuteScriptCom implements BasicCommand{
    @Override
    public void execute(String[] args) {
        if (args.length == 1) {
            String fileName = args[1];
            Receiver.executeScript(fileName);
        } else {
            System.out.println("You have inputted the command incorrectly");
        }
    }

    @Override
    public String getName() {
        return "Execute_script";
    }

    @Override
    public String getDescription() {
        return "execute the script from the provided file";
    }
}
