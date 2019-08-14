public class lc292_NimGame {
    static class Solution {
        public boolean canWinNim(int n) {
//            if (n < 4) return true;
//            boolean[] result = new boolean[n + 1];
//            result[0] = true;
//            result[1] = true;
//            result[2] = true;
//            result[3] = true;
//            for (int i = 4; i <= n; i++) {
//                result[i] = !(result[i - 1] && result[i - 2] && result[i - 3]);
//            }
//            return result[n];
            return !(n % 4 == 0);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Solution tool = new Solution();
        boolean result = tool.canWinNim(n);
        System.out.println(result);
    }
}
