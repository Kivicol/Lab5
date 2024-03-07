package src.data;

public class Coordinates implements Validation {
    private int x;
    private Long y; //Поле не может быть null

    public Coordinates(int x, Long y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return x + ";" + y;
    }

    @Override
    public boolean validate() {
        if (y == null) return false;
        return true;
    }

}
