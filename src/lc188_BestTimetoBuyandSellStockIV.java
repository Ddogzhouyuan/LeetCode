public class lc188_BestTimetoBuyandSellStockIV {
    static class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length <= 1) return 0;

            if (k >= prices.length / 2) {
                int buy = 0;
                int sell = 0;
                int tempProfit = 0;
                int totalProfit = 0;
                for (int i = 0; i < prices.length - 1; i++) {
                    buy = i;
                    sell = buy + 1;
                    while(sell < prices.length && prices[buy] < prices[sell] && prices[sell] > prices[sell - 1]) sell++;
                    tempProfit = prices[sell - 1] - prices[buy];
                    totalProfit += tempProfit;
                    i = sell - 1;
                }
                return totalProfit;
            }

            int maxProfit = 0;
            int[][] f = new int[k + 1][prices.length];
            for (int kk = 1; kk <= k; kk++) {
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
        int[] prices = {3,2,6,5,0,3};
        int K = 2;
        Solution tool = new Solution();
        int result = tool.maxProfit(K, prices);
        System.out.println(result);
    }
}
