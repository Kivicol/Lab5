package src;

import src.command.Client;

public class Main {
    public static void main(String[] args) {
        Client console = new Client();
        console.start(System.in, args);
    }
}