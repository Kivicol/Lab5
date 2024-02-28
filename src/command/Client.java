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

        System.out.println("Welcome to app!");
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            invoker.startExecuting(command);
        }
    }
}
