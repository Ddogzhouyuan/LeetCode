public class lc581_ShortestUnsortedContinuousSubarray {
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int begin = -1;
            int end = -2;
            int min = nums[n - 1];
            int max = nums[0];
            for (int i = 1; i < n; i++) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[n - 1 - i]);
                if (max > nums[i]) {
                    end = i;
                }
                if (min < nums[n - 1 - i]) {
                    begin = n - 1 - i;
                }
            }
            return end - begin + 1;
        }
    }
}
