public class lc209_MinimumSizeSubarraySum {
    static class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int sum = 0;
            int result = Integer.MAX_VALUE;
            int start = 0;
            int sum_max = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sum_max = Math.max(sum_max, sum);
                if (sum >= s) {
                    while (sum >= s && start <= i) {
                        result = Math.min(i - start + 1, result);
                        sum -= nums[start++];
                    }
                }
            }
            if (sum_max < s) return 0;
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,4,4};
        int s = 4;
        Solution tool = new Solution();
        int result = tool.minSubArrayLen(s, nums);
        System.out.println(result);
    }
}