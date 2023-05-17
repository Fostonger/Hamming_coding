import consoleReader.ConsoleReader;
import resultHandler.HammingResult;
import resultHandler.HammingResultInterpreter;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] data = Arrays.stream(args)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        if (data.length < 3) {
            System.out.println("Program launch arguments haven't bits data, pass it here:");
            ConsoleReader reader = new ConsoleReader(System.in);
            data = reader.readDataFromConsole();
        }
//        data = {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0};
        HammingResultInterpreter hammingResult = new HammingResult();
        System.out.println(hammingResult.handleResult(data));
    }
}
