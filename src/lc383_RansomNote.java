import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc383_RansomNote {
    static class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            boolean result = false;
            if (ransomNote.length() > magazine.length() || magazine == null) return result;
            List<Character> ransomLs = new ArrayList<>();
            for (int i = 0; i < ransomNote.length(); i++) ransomLs.add(ransomNote.charAt(i));
            for (int i = 0; i < magazine.length(); i++) {
                if (ransomLs.contains(magazine.charAt(i))) {
                    ransomLs.remove((Character) magazine.charAt(i));
                }
            }
            if (ransomLs.size() > 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "ba";
        Solution tool = new Solution();
        boolean result = tool.canConstruct(ransomNote, magazine);
        System.out.println(result);
    }
}
