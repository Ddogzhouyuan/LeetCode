public class lc309_BestTimetoBuyandSellStockwithCooldown {
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length <= 1) return 0;
            int[] buy = new int[prices.length];
            int[] sell = new int[prices.length];
            int[] rest = new int[prices.length];
            for (int i = 0; i < prices.length; i++) {
                if (i == 0) {
                    buy[i] = -prices[i];
                    sell[i] = 0;
                    rest[i] = 0;
                } else {
                    buy[i] = Math.max(rest[i - 1] - prices[i], buy[i - 1]);
                    sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
                    rest[i] = Math.max(Math.max(buy[i - 1], sell[i - 1]), rest[i - 1]);
                }
            }
            int n = prices.length - 1;
            int result = Math.max(Math.max(buy[n], sell[n]), rest[n]);
            return result;
        }
    }

    public static void main(String[] args) {
        int[] prices = {2,1,1,1};
        Solution tool = new Solution();
        int result = tool.maxProfit(prices);
        System.out.println(result);
    }

}
