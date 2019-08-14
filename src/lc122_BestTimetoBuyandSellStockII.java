public class lc122_BestTimetoBuyandSellStockII {
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
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
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        Solution tool = new Solution();
        int result = tool.maxProfit(prices);
        System.out.println(result);
    }
}
