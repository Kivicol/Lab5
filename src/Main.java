package src;

import src.command.Client;
import src.command.Receiver;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Client console = new Client();
        console.start(System.in, args);
    }
}