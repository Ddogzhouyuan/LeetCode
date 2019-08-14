import java.util.HashSet;

public class lc202_HappyNumber {
    static class Solution {
        HashSet<Integer> set = new HashSet<>();
        public boolean isHappy(int n) {
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            String str = String.valueOf(n);
            int result = 0;
            for (int i = 0; i < str.length(); i++) {
                result += (str.charAt(i) - '0') * (str.charAt(i) - '0');
            }
            if (result == 1) {
                return true;
            } else {
                return isHappy(result);
            }
        }
    }

    public static void main(String[] args) {
        int n = 28;
        Solution tool = new Solution();
        boolean result = tool.isHappy(n);
        System.out.println(result);
    }
}
