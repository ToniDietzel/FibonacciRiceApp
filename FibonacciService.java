// Service Class for Fibonacci Logic //
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciService {

    // Generate Fibonacci Sequence //
    public List<BigInteger> generateFibonacci(int n) {
        List<BigInteger> sequence = new ArrayList<>();
        if (n >= 1) sequence.add(BigInteger.ONE);
        if (n >= 2) sequence.add(BigInteger.ONE);

        for (int i = 2; i < n; i++) {
            BigInteger next = sequence.get(i - 1).add(sequence.get(i - 2));
            sequence.add(next);
        }

        return sequence;
    }
}