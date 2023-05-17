package consoleReader;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleReader {
    private Scanner scanner;
    private String illegalArgMessage = "Illegal arguments passed!\nArguments should be passed separated with whitespace and it should be integers";
    public ConsoleReader(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public Integer[] readDataFromConsole() {
        Integer[] result = new Integer[0];
        while (result.length == 0) {
            String line = "";
            line += scanner.nextLine();
            try {
                result = Arrays.stream(line.split("\\s+"))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
            } catch (NumberFormatException e) {
                System.out.println(illegalArgMessage);
                continue;
            }
            if (result.length == 0)
                System.out.println(illegalArgMessage);
        }
        return result;
    }
}
