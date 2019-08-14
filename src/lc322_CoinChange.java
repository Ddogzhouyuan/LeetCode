import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc322_CoinChange {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            long[] dp = new long[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            if (dp[amount] > amount) {
                return -1;
            } else {
                return (int)dp[amount];
            }
        }
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        Solution tool = new Solution();
        int result = tool.coinChange(coins, amount);
        System.out.println(result);
    }
}
