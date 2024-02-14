package src.command.commands;

public interface BasicCommand {
    public void execute(String[] args);
    public String getName();
    public String getDescription();
}
