import java.util.LinkedList;

public class lc387_FirstUniqueCharacterinaString {
    static class Solution {
        public int firstUniqChar(String s) {
            LinkedList<Character> ls1 = new LinkedList<>();
            LinkedList<Character> ls2 = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                if (!ls1.contains(s.charAt(i)) && !ls2.contains(s.charAt(i))) {
                    ls1.add(s.charAt(i));
                } else if (ls1.contains(s.charAt(i)) && !ls2.contains(s.charAt(i))) {
                    ls1.removeFirstOccurrence(s.charAt(i));
                    ls2.add(s.charAt(i));
                } else if (!ls1.contains(s.charAt(i)) && ls2.contains(s.charAt(i))) {
                    continue;
                } else {
                    continue;
                }
            }
            if (ls1.size() == 0) return -1;
            Character temp = ls1.getFirst();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == temp) return i;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        Solution tool = new Solution();
        int result = tool.firstUniqChar(s);
        System.out.println(result);
    }
}
