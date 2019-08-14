import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class lc3_LongestSubstringWithoutRepeatingCharacters {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> hashset = new HashSet<>();
            Queue<Character> queue = new LinkedList<>();
            int max_len = 0;
            for (int i=0; i<s.length(); i++) {
                char ch = s.charAt(i);
                if (hashset.contains(ch)) {
                    while(queue.peek() != ch) {
                        hashset.remove(queue.poll());
                    }
                    hashset.remove(queue.poll());
                }
                hashset.add(ch);
                queue.offer(ch);
                if (hashset.size() > max_len) {
                    max_len = hashset.size();
                }
            }
            return max_len;
        }
    }
}
