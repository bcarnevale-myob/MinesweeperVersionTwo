package Game;

import java.util.Scanner;

public class ConsoleReader implements IReader {

    @Override
    public String prompt(String message) {
        Scanner systemInScanner = new Scanner(System.in);
        System.out.println(message);

        return systemInScanner.nextLine();
    }

}
