package src.command.Utility;

import java.util.Scanner;

public class CustomScanner {
    public static Scanner customScanner = new Scanner(System.in);

    public static Scanner getCustomScanner() {
        return customScanner;
    }
}
