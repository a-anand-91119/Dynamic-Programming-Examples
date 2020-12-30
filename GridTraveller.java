import java.util.HashMap;
import java.util.Map;

public class GridTraveller {

    public static void main(String[] args) {
        System.out.println(gridTraveller(1, 1, new HashMap<>()));
        System.out.println(gridTraveller(2, 3, new HashMap<>()));
        System.out.println(gridTraveller(3, 2, new HashMap<>()));
        System.out.println(gridTraveller(28, 28, new HashMap<>()));
    }

    public static long gridTraveller(final long x, final long y, Map<String, Long> memo) {
        final String memoKey = x + "|" + y;
        if(memo.containsKey(memoKey)) return memo.get(memoKey);
        if (x == 0 || y == 0) return 0;
        if (x == 1 && y == 1) return 1;

        memo.put(memoKey, gridTraveller(x - 1, y, memo) + gridTraveller(x, y - 1, memo));

        return memo.get(memoKey);
    }
}
