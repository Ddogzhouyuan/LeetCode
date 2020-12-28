package LeetCode_CN;

import java.util.Map;

public class lc309_BestTimetoBuyandSellStockwithCooldown {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
            int n = prices.length;
            int[] buy = new int[n];
            int[] sell = new int[n];
            int[] rest = new int[n];
            for (int i = 0; i < n; i ++) {
                if (i == 0) {
                    buy[0] = -prices[0];
                    sell[0] = 0;
                    rest[0] = 0;
                } else {
                    buy[i] = Math.max(rest[i - 1] - prices[i], buy[i - 1]);
                    sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
                    rest[i] = Math.max(Math.max(buy[i - 1], sell[i - 1]), rest[i - 1]);
                }
            }
            return Math.max(Math.max(buy[n - 1], sell[n - 1]), rest[n - 1]);
        }
    }
}
