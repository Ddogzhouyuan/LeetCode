import java.util.*;

public class lc30_SubstringwithConcatenationofAllWords {
    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            if (s == null || s.length() == 0 || words.length == 0 || words == null) return result;
            HashMap<String, Integer> words_cnt = new HashMap<>();
            int len = words[0].length();
            int window = len * words.length;
            if (s.length() < window) return result;
            int start = 0;
            int end = 0;
            int count = 0;

            for (String i: words) {
                if (words_cnt.containsKey(i)) {
                    words_cnt.put(i, words_cnt.get(i) + 1);
                } else {
                    words_cnt.put(i, 1);
                }
            }

            while (end <= s.length()) {
                HashMap<String, Integer> s_sep = new HashMap<>();
                count = words_cnt.size();
                end = start + window;
                String temp = s.substring(start, end);
                for (int i = 0; i <= window - 1; i = i + len) {
                    String s_i = temp.substring(i, i + len);
                    if (s_sep.containsKey(s_i)) {
                        s_sep.put(s_i, s_sep.get(s_i) + 1);
                    } else {
                        s_sep.put(s_i, 1);
                    }
                }
                Set<String> set1 = new HashSet<>(words_cnt.keySet());
                set1.removeAll(s_sep.keySet());
                if (set1.isEmpty()) {
                    for (String j: words_cnt.keySet()) {
                        if (words_cnt.get(j) == s_sep.get(j)) {
                            count--;
                        }
                    }
                    if (count == 0) result.add(start);
                }
                start++;
                end = start + window;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        String s = "w";
        String[] words = {"w"};
        Solution tool = new Solution();
        List<Integer> result = tool.findSubstring(s, words);
        System.out.println(result.toString());
    }
}
