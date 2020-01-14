public class lc389_FindtheDifference {
    static class Solution {
        public char findTheDifference(String s, String t) {
            char result = 0;
            for (char i: s.toCharArray()) {
                result ^= i;
            }
            for (char i: t.toCharArray()) {
                result ^= i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        Solution tool = new Solution();
        char result = tool.findTheDifference(s, t);
        System.out.println(result);
    }
}
