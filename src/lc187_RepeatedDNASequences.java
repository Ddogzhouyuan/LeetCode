import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class lc187_RepeatedDNASequences {
    static class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            HashSet<String> seen = new HashSet<>();
            HashSet<String> repeat = new HashSet<>();
            for (int i = 0; i + 9 < s.length(); i++) {
                String temp = s.substring(i, i + 10);
                if (!seen.add(temp)) {
                    repeat.add(temp);
                }
            }
            return new ArrayList<>(repeat);
        }
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Solution tool = new Solution();
        List<String> result = tool.findRepeatedDnaSequences(s);
        for (String i: result) {
            System.out.println(i);
        }
    }
}
