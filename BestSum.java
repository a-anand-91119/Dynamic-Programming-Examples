import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {

    public static void main(String[] args) {
        System.out.println("7 => " + bestSum(7, new long[]{5L, 3L, 4L, 7L}, new HashMap<>()));
        System.out.println("7 => " + bestSum(7, new long[]{2L, 4L}, new HashMap<>()));
        System.out.println("8 => " + bestSum(8, new long[]{2L, 3L, 5L}, new HashMap<>()));
        System.out.println("0 => " + bestSum(0, new long[]{2L, 4L}, new HashMap<>()));
        System.out.println("45 => " + bestSum(45, new long[]{4L, 6L, 3L, 7L, 9L}, new HashMap<>()));
        System.out.println("357 => " + bestSum(357, new long[]{7L, 14L}, new HashMap<>()));
        System.out.println("100 => " + bestSum(100, new long[]{1L, 2L, 5L, 25L}, new HashMap<>()));
        System.out.println("3000 => " + bestSum(3000, new long[]{7L, 14L}, new HashMap<>()));
    }

    public static List<Long> bestSum(long targetSum, long[] numbers, Map<Long, List<Long>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        List<Long> bestList = null;

        for (long number : numbers) {
            List<Long> someList = bestSum(targetSum - number, numbers, memo);
            if (someList != null) {
                someList = new ArrayList<>(someList);
                someList.add(number);
                if (bestList == null || someList.size() < bestList.size())
                    bestList = someList;
            }
        }
        memo.put(targetSum, bestList);
        return bestList;
    }
}
