import java.util.*;

public class lc140_WordBreakII {
    static class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            if (s.length() == 0) {
                return new ArrayList<>();
            }
            Set<String> set = new HashSet<>();
            for (String word: wordDict) {
                set.add(word);
            }
            return backtrack(s, set, new HashMap<>());
        }

        public List<String> backtrack(String s, Set<String> set, Map<String, List<String>> map) {
            if (map.containsKey(s)) {
                return map.get(s);
            }

            List<String> result = new ArrayList<>();
            if (set.contains(s)) {
                result.add(s);
            }

            for (int i = 1; i < s.length(); i++) {
                String prefix = s.substring(0, i);
                if (set.contains(prefix)) {
                    List<String> tempList = backtrack(s.substring(i), set, map);
                    for (int j = 0; j < tempList.size(); j++) {
                        result.add(prefix + " " + tempList.get(j));
                    }
                }
            }
            map.put(s, result);
            return result;
        }
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        Solution tool = new Solution();
        List<String> result = tool.wordBreak(s, wordDict);
        for (String i : result) {
            System.out.println(i);
        }
    }
}
