public class lc55_JumpGame {
    static class Solution {
        public boolean canJump(int[] nums) {
            boolean result = false;
            int maxIndex = nums.length - 1;
            int maxJump = nums[0];
            for(int i = 0; i <= maxJump; i++) {
                maxJump = Math.max(maxJump, i + nums[i]);
                if (maxJump >= maxIndex) return true;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        Solution tool = new Solution();
        boolean result = tool.canJump(nums);
        System.out.println(result);
    }
}
