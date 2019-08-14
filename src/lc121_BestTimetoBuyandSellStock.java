public class lc121_BestTimetoBuyandSellStock {
    static class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            if (prices.length == 0 || prices == null) return maxProfit;
            int sofarMin = prices[0];
            for (int i = 0; i < prices.length; i++) {
                if (sofarMin > prices[i]) sofarMin = prices[i];
                if (maxProfit < prices[i] - sofarMin) {
                    maxProfit = prices[i] - sofarMin;
                }
            }
            return maxProfit;
        }
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Solution tool = new Solution();
        int result = tool.maxProfit(prices);
        System.out.println(result);
    }
}
