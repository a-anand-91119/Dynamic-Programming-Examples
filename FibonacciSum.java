import java.util.HashMap;
import java.util.Map;

public class FibonacciSum {
    /*
     * Function to return the nth number of the fibonacci series.
     *      0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597,
     *      2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811
     */
    public static void main(String[] args) {
        System.out.println(fibSum(6, new HashMap<>()));
        System.out.println(fibSum(7, new HashMap<>()));
        System.out.println(fibSum(8, new HashMap<>()));
        System.out.println(fibSum(51, new HashMap<>()));
    }

    public static long fibSum(long n, Map<Long, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n == 1) return 0;
        if (n == 2) return 1;

        memo.put(n, fibSum(n - 1, memo) + fibSum(n - 2, memo));
        return memo.get(n);
    }
}
