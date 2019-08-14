public class lc152_MaximumProductSubarray {
    static class Solution {
        public int maxProduct(int[] nums) {
            int cumpro = 1;
            int maxpro = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                cumpro *= nums[i];
                if (cumpro > maxpro) maxpro = cumpro;
                if (nums[i] == 0) cumpro = 1;
            }
            cumpro = 1;
            for (int i = nums.length - 1; i > -1; i--) {
                cumpro *= nums[i];
                if (cumpro > maxpro) maxpro = cumpro;
                if (nums[i] == 0) cumpro = 1;
            }
            return maxpro;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,-2};
        Solution tool = new Solution();
        int result = tool.maxProduct(nums);
        System.out.println(result);
    }
}
