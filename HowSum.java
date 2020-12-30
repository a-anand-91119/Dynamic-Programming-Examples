import java.util.*;

public class HowSum {

    public static void main(String[] args) {
        System.out.println(howSum(7, new long[]{5L, 3L, 4L, 7L}, new HashMap<>()));
        System.out.println(howSum(7, new long[]{2L, 4L}, new HashMap<>()));
        System.out.println(howSum(0, new long[]{2L, 4L}, new HashMap<>()));
        System.out.println(howSum(45, new long[]{4L, 6L, 3L, 7L, 9L}, new HashMap<>()));
        System.out.println(howSum(357, new long[]{7L, 14L}, new HashMap<>()));
        System.out.println(howSum(3000, new long[]{7L, 14L}, new HashMap<>()));
    }

    private static List<Long> howSum(long targetSum, long[] numbers, Map<Long, List<Long>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum < 0) return null;
        if (targetSum == 0) return new ArrayList<>();

        for (long number : numbers) {
            List<Long> someList = howSum(targetSum - number, numbers, memo);
            if (someList != null) {
                someList.add(number);
                memo.put(targetSum, someList);
                return memo.get(targetSum);
            }
        }
        memo.put(targetSum, null);
        return memo.get(targetSum);
    }
}
