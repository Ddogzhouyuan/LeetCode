import java.util.Arrays;

public class lc238_ProductofArrayExceptSelf {
    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] res = new int[nums.length];
            int right = 1;
            int left = 1;
            Arrays.fill(res, 1);
            for (int i = 0; i < nums.length; i++) {
                res[i] *= left;
                left *= nums[i];
            }
            for (int i = nums.length - 1; i > -1; i--) {
                res[i] *= right;
                right *= nums[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Solution tool = new Solution();
        int[] result = tool.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}
