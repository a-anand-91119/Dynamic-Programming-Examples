import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    public static void main(String[] args) {

        System.out.println(canConstruct("abcdef",
                new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(canConstruct("",
                new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()));
        System.out.println(canConstruct("skateboard",
                new String[]{"bo", "rd", "ate", "ska", "sk", "boar"}, new HashMap<>()));
        System.out.println(canConstruct("enterapotentpot",
                new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee"}, new HashMap<>()));
    }

    public static boolean canConstruct(String targetString, String[] wordBank, Map<String, Boolean> memo) {
        if(memo.containsKey(targetString)) return memo.get(targetString);
        if (targetString.length() == 0) return true;

        for (String word : wordBank) {
            if (targetString.startsWith(word)) {
                memo.put(targetString, canConstruct(targetString.replaceFirst(word, ""), wordBank, memo));
                if (memo.get(targetString))
                    return true;
            }
        }
        memo.put(targetString, false);
        return false;
    }
}
