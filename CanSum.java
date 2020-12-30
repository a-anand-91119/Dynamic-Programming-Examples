import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public static void main(String[] args) {
        System.out.println(canSum(7, new long[]{2L, 4L}, new HashMap<>()));
        System.out.println(canSum(7, new long[]{5L, 3L, 4L, 7L}, new HashMap<>()));
        System.out.println(canSum(45, new long[]{1L, 4L, 6L, 3L, 7L, 9L}, new HashMap<>()));
        System.out.println(canSum(300, new long[]{7L, 14L}, new HashMap<>()));
        System.out.println(canSum(3000, new long[]{7L, 14L}, new HashMap<>()));
    }

    public static boolean canSum(long targetSum, long[] numbers, Map<Long, Boolean> memo){
        if(memo.containsKey(targetSum)) return memo.get(targetSum);
        if(targetSum < 0) return false;
        if(targetSum == 0) return true;

        for(long number : numbers){
            if (canSum(targetSum - number, numbers, memo)){
                memo.put(targetSum, true);
                return memo.get(targetSum);
            }
        }
        memo.put(targetSum, false);
        return memo.get(targetSum);
    }
}
