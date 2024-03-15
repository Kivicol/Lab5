package src.command.exceptions;

public class NoElementException extends Throwable {
    public NoElementException(int id){
        System.out.println("No element in collection with this id:" + id);
    }
}
