import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc49_GroupAnagrams {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            boolean[] type = new boolean[strs.length];
            List<List<String>> result = new ArrayList<>();
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                if (type[i] == false) {
                    temp = new ArrayList<>();
                    for (int j = i; j < strs.length; j++) {
                        if (j == i && type[j] == false) {
                            temp.add(strs[j]);
                            type[j] = true;
                        } else if (type[j] == false) {
                            if (isAnagram(strs[i], strs[j])) {
                                temp.add(strs[j]);
                                type[j] = true;
                            }
                        }

                    }
                    result.add(new ArrayList<>(temp));
                }
            }
            return result;
        }

        public boolean isAnagram(String s, String t) {
            if (s.equals(t)) return true;
            if (s.length() != t.length()) return false;
            int[] ls1 = new int[26];
            int[] ls2 = new int[26];
            for (int i = 0; i < s.length(); i++) {
                ls1[s.charAt(i) - 97] += 1;
                ls2[t.charAt(i) - 97] += 1;
            }
            for (int i = 0; i < ls1.length; i++) {
                if (ls1[i] != ls2[i]) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution tool = new Solution();
        List<List<String>> result = tool.groupAnagrams(strs);

    }
}
