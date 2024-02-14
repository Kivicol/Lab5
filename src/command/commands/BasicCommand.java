package src.command.commands;

public interface BasicCommand {
    public void execute(String[] args);
    public void getName();
    public void getDescription();
}
