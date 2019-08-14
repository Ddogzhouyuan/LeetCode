import java.util.HashMap;

public class lc313_SuperUglyNumber {
    static class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            if (primes == null || primes.length == 0) return 0;

            int[] dp = new int[n];
            HashMap<Integer, Integer> cursor = new HashMap<>();
            dp[0] = 1;
            for (int i : primes) {
                cursor.put(i, 0);
            }

            for (int i = 1; i < n; i++) {
                int min = Integer.MAX_VALUE;
                for (Integer key: cursor.keySet()) {
                    min = Math.min(min, dp[cursor.get(key)] * key);
                }
                dp[i] = min;
                for (Integer key: cursor.keySet()) {
                    if (dp[i] == dp[cursor.get(key)] * key) {
                        cursor.put(key, cursor.get(key) + 1);
                    }
                }
            }
            return dp[n - 1];
        }
    }

    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2,7,13,19};
        Solution tool = new Solution();
        int result = tool.nthSuperUglyNumber(n, primes);
        System.out.println(result);
    }
}
