package hammingCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class HammingCoding {
    public static int findDeviantIndex(Integer[] data) {
        if ( !IsPowerOfTwo(data.length+1) || data.length < 3 ) {
            throw new IllegalArgumentException("The program is working only with 7-digit data!");
        }
        List<Integer> dataList = new ArrayList<Integer>(Arrays.<Integer>asList(data));
        dataList.add(0, 0);
        int cur_phase = 1;
        int result = 0;
        while (cur_phase < dataList.size()) {
            int finalCur_phase = cur_phase;
            int[] intStream = IntStream.range(0, dataList.size())
                    .filter(i -> (finalCur_phase & i) != 0).toArray();
            int parityCheck = Arrays.stream(intStream)
                    .reduce(0, (a, b) -> a ^ dataList.get(b));
            result += (parityCheck != 0) ? cur_phase : 0;
            cur_phase *= 2;
        }
        return result;
    }

    public static boolean IsPowerOfTwo(long x) { return (x & (x - 1)) == 0; }
}
