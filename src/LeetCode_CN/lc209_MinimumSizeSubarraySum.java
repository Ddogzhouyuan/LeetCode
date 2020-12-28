package LeetCode_CN;

public class lc209_MinimumSizeSubarraySum {
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int sum = 0;
            int sumMax = 0;
            int result = Integer.MAX_VALUE;
            int start = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sumMax = Math.max(sumMax, sum);
                if (sum >= s) {
                    while (start <= i && sum >= s) {
                        result = Math.min(result, i - start + 1);
                        sum -= nums[start];
                        start++;
                    }
                }
            }
            if (sumMax < s) {
                return 0;
            }
            return result;
        }
    }
}
