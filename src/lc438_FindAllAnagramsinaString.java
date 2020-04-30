import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class lc438_FindAllAnagramsinaString {
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new LinkedList<>();
            if (s.length() < p.length()) {
                return result;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (char c: p.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int count = map.size();

            int begin = 0;
            int end = 0;
            int head = 0;
            int len = Integer.MAX_VALUE;

            while (end < s.length()) {
                char c = s.charAt(end);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        count--;
                    }
                }
                end++;

                while (count == 0) {
                    char tempC = s.charAt(begin);
                    if (map.containsKey(tempC)) {
                        map.put(tempC, map.get(tempC) + 1);
                        if (map.get(tempC) > 0) {
                            count++;
                        }
                    }
                    if (end - begin == p.length()) {
                        result.add(begin);
                    }
                    begin++;
                }
            }
            return result;
        }
    }
}
