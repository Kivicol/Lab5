package src.command.commands;

public class ExitCom implements BasicCommand{
    @Override
    public void execute(String[] args){
        System.exit(1);
    }

    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public String getDescription() {
        return "exit the program";
    }
}
