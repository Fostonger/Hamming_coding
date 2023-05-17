package resultHandler;

import hammingCode.HammingCoding;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HammingResult implements HammingResultInterpreter {
    @Override
    public String handleResult(Integer[] sequence) {
        int hammingResult;
        try {
            hammingResult = HammingCoding.findDeviantIndex(sequence);
        } catch (IllegalArgumentException e) {
            return "The program can operate only with N number of bits, where N+1 is a power of 2";
        }
        if (hammingResult == 0)
            return "The data is perfectly correct!";
        sequence[hammingResult-1] = (sequence[hammingResult-1] - 1) * (sequence[hammingResult-1] - 1);
        Integer[] indexesStream = IntStream.range(1, sequence.length+1)
                .filter(i -> !HammingCoding.IsPowerOfTwo(i))
                .map(i -> sequence[i-1])
                .boxed()
                .toArray(Integer[]::new);
        return "The data is corrupted! Affected bit index is " + hammingResult + ".\n" +
                "The correct data should be as follows:\n" +
                Arrays.stream(indexesStream)
                        .map(String::valueOf)
                        .reduce("", (a, b) -> a + b);
    }
}
