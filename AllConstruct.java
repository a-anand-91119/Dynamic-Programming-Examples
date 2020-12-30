import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstruct {

    public static void main(String[] args) {
        System.out.println("Creating: purple");
        allConstruct("purple",
                new String[]{"purp", "p", "ur", "le", "purpl"}, new HashMap<>()).forEach(System.out::println);
        System.out.println("Creating: abcdef");
        allConstruct("abcdef",
                new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"}, new HashMap<>()).forEach(System.out::println);
        System.out.println("Creating: skateboard");
        allConstruct("skateboard",
                new String[]{"bo", "rd", "ate", "ska", "sk", "boar"}, new HashMap<>()).forEach(System.out::println);
        System.out.println("Creating: enterapotentpot");
        allConstruct("enterapotentpot",
                new String[]{"a", "p", "ent", "enter", "ot", "o", "t"}, new HashMap<>()).forEach(System.out::println);
        System.out.println("Creating: eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef");
        allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[]{"e", "ee", "eee", "eeee", "eeeee"}, new HashMap<>()).forEach(System.out::println);
        System.out.println("Creating: ");
        allConstruct("",
                new String[]{"ab", "abc", "cd", "def", "abcd"}, new HashMap<>()).forEach(System.out::println);
    }

    private static List<List<String>> allConstruct(String targetString, String[] wordBank, Map<String, List<List<String>>> memo) {
        if(memo.containsKey(targetString)) return memo.get(targetString);
        if (targetString.length() == 0) return getListOfEmptyList();

        List<List<String>> possibleCombinations = new ArrayList<>();
        for (String word : wordBank) {
            if (targetString.startsWith(word)) {
                List<List<String>> someList = allConstruct(targetString.replaceFirst(word, ""), wordBank, memo);
                someList.forEach(list -> list.add(0, word));
                possibleCombinations.addAll(someList);
            }
        }
        memo.put(targetString, possibleCombinations);
        return possibleCombinations;
    }

    private static List<List<String>> getListOfEmptyList() {
        List<List<String>> returnList = new ArrayList<>();
        returnList.add(new ArrayList<>());
        return returnList;
    }
}
