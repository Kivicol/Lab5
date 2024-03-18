package src.command;

import java.io.InputStream;
import src.command.Invoker;
import src.command.Receiver;
import java.util.Scanner;

public class Client {
    public void start(InputStream input, String[] args){
        Scanner scanner = new Scanner(input);
        Invoker invoker = new Invoker();
        new Receiver();

        System.out.println("Welcome to the program!\nTo see available commands, write \"help\"");
        while (scanner.hasNextLine()) {
            try{
            String command = scanner.nextLine();
            invoker.startExecuting(command);
            } catch (NullPointerException e) {
                System.out.println("No command provided, try again");
            }
        }
    }
}
