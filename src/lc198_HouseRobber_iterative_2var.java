public class lc198_HouseRobber_iterative_2var {
    static class Solution {
        public int rob(int[] nums) {
            if (nums.length == 0) return 0;

            int v1 = 0;
            int v2 = 0;
            for (int i = 0; i < nums.length; i++) {
                int temp = v2;
                v2 = Math.max(v2, v1 + nums[i]);
                v1 = temp;
            }
            return v2;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution tool = new Solution();
        int result = tool.rob(nums);
        System.out.println(result);
    }
}
