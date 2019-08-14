import java.util.Arrays;

public class lc164_MaximumGap {
    static class Solution {
        public int maximumGap_quicksort(int[] nums) {
            if (nums == null || nums.length < 2) return 0;
            Arrays.sort(nums);
            int maxRange = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                maxRange = Math.max(maxRange, nums[i + 1] - nums[i]);
            }
            return maxRange;
        }

        public int maximumGap(int[] nums) {
            // bucket sort
            if (nums == null || nums.length < 2) return 0;
            int small = Integer.MAX_VALUE;
            int big = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                small = Math.min(small, nums[i]);
                big = Math.max(big, nums[i]);
            }

            int[] bucket = new int[big - small + 1];
            for (int i = 0; i < nums.length; i++) {
                bucket[nums[i] - small]++;
            }
            int[] nums_sort = new int[nums.length];
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                while (bucket[i] > 0) {
                    nums_sort[index] = i + small;
                    index++;
                    bucket[i]--;
                }
            }

            int maxRange = 0;
            for (int i = 0; i < nums_sort.length - 1; i++) {
                maxRange = Math.max(maxRange, nums_sort[i + 1] - nums_sort[i]);
            }
            return maxRange;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,6,9,1};
        Solution tool = new Solution();
        int result = tool.maximumGap(nums);
        System.out.println(result);
    }
}
