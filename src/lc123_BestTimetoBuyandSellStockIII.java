import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class lc123_BestTimetoBuyandSellStockIII {
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) return 0;

            int K = 2;
            int maxProfit = 0;
            int[][] f = new int[K + 1][prices.length];
            for (int kk = 1; kk <= K; kk++) {
                int tempMax = f[kk - 1][0] - prices[0];
                for (int ii = 1; ii < prices.length; ii++) {
                    f[kk][ii] = Math.max(f[kk][ii - 1], prices[ii] + tempMax);
                    tempMax = Math.max(tempMax, f[kk - 1][ii] - prices[ii]);
                    maxProfit = Math.max(f[kk][ii], maxProfit);
                }
            }
            return maxProfit;
        }
    }

    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        Solution tool = new Solution();
        int result = tool.maxProfit(prices);
        System.out.println(result);
    }
}
