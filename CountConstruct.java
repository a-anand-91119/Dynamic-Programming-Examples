import java.util.HashMap;
import java.util.Map;

public class CountConstruct {

    public static void main(String[] args) {
        System.out.println(countConstruct("purple",
                new String[]{"purp", "p", "ur", "le", "purpl"}, new HashMap<>()));
        System.out.println(countConstruct("abcdef",
                new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(countConstruct("",
                new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(countConstruct("skateboard",
                new String[]{"bo", "rd", "ate", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(countConstruct("enterapotentpot",
                new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee"}, new HashMap<>()));
    }

    private static long countConstruct(String targetString, String[] wordBank, Map<String, Long> memo) {
        if (memo.containsKey(targetString)) return memo.get(targetString);
        if (targetString.length() == 0) return 1;

        long count = 0;
        for (String word : wordBank) {
            if (targetString.startsWith(word))
                count += countConstruct(targetString.replaceFirst(word, ""), wordBank, memo);
        }
        memo.put(targetString, count);
        return count;
    }
}
