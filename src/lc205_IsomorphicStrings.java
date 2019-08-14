import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class lc205_IsomorphicStrings {
    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            HashMap<Character, Integer> hashmap1 = new HashMap<>();
            HashMap<Character, Integer> hashmap2 = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (hashmap1.containsKey((Character) s.charAt(i))) {
                    int temp = hashmap1.get((Character) s.charAt(i));
                    temp++;
                    hashmap1.put((Character) s.charAt(i), temp);
                } else {
                    hashmap1.put((Character) s.charAt(i), 1);
                }
            }
            for (int i = 0; i < t.length(); i++) {
                if (hashmap2.containsKey((Character) t.charAt(i))) {
                    int temp = hashmap2.get((Character) t.charAt(i));
                    temp++;
                    hashmap2.put((Character) t.charAt(i), temp);
                } else {
                    hashmap2.put((Character) t.charAt(i), 1);
                }
            }
            Set<Character> set1 = hashmap1.keySet();
            Set<Character> set2 = hashmap2.keySet();
            if (set1.size() != set2.size()) return false;
            Set<Character> set_transect = new HashSet<Character>(set1);
            set_transect.retainAll(set2);
            set1.removeAll(set_transect);
            set2.removeAll(set_transect);
            if (set_transect.size() > 0) {
                for (Character i: set_transect) {
                    if (hashmap1.get((Character) i) != hashmap2.get((Character) i)) return false;
                }
            }
            if (set1.size() == 0 && set2.size() == 0) return true;
            int[] freq1 = new int[set1.size()];
            int[] freq2 = new int[set1.size()];
            int idx = 0;
            for (Character i: set1) freq1[idx++] = hashmap1.get((Character) i);
            idx = 0;
            for (Character i: set2) freq2[idx++] = hashmap2.get((Character) i);
            Arrays.sort(freq1);
            Arrays.sort(freq2);
            for (int i = 0; i < freq1.length; i++) {
                if (freq1[i] != freq2[i]) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "abb";
        String t = "ab";
        Solution tool = new Solution();
        boolean result = tool.isIsomorphic(s, t);
        System.out.println(result);
    }
}
