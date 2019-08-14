import java.util.Collections;
import java.util.HashMap;

public class lc279_PerfectSquares_DP {
    static class Solution {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>() {{put(0,0); put(1,1); put(2,2);}};
        public int numSquares(int n) {
            if (n <= 0) return 0;
            if (memo.containsKey(n)) return memo.get(n);
            int start = Collections.max(memo.keySet());
            for (int i = start; i <= n; i++) {
                if (memo.containsKey(i)) {
                    continue;
                } else {
                    helper(i);
                }
            }
            return memo.get(n);
        }

        public int helper(int n) {
            if (memo.containsKey(n)) {
                return memo.get(n);
            }

            int cntSquare = Integer.MAX_VALUE;
            for (int i = 1; i * i <= n; i++) {
                cntSquare = Math.min(cntSquare, helper(n - i * i) + 1);
            }
            memo.put(n, cntSquare);
            return cntSquare;
        }
    }

    public static void main(String[] args) {
        int n = 14;
        Solution tool = new Solution();
        int result = tool.numSquares(n);
        System.out.println(result);
    }
}
