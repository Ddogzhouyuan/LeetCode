package LeetCode_CN;

import java.util.Arrays;

public class lc16_3SumClosest {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int targetDiffI = 0;
            int diff = Integer.MAX_VALUE;
            int result = 0;
            for (int i = 0; i < (nums.length - 2); i++) {
                targetDiffI = target - nums[i];
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (j < k && Math.abs(target - nums[i] - nums[j] - nums[k]) < diff) {
                        result = nums[i] + nums[j] + nums[k];
                        diff = Math.abs(target - result);
                    }
                    if (targetDiffI == nums[j] + nums[k]) {
                        return target;
                    } else if (targetDiffI < nums[j] + nums[k]) {
                        k--;
                    } else {
                        j++;
                    }

                }
            }
            return result;
        }
    }
}
