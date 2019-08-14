public class lc334_IncreasingTripletSubsequence {
    static class Solution {
        public boolean increasingTriplet(int[] nums) {
            if (nums == null || nums.length <= 2) return false;
            int small = Integer.MAX_VALUE;
            int big = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= small) {
                    small = nums[i];
                } else if (nums[i] <= big) {
                    big = nums[i];
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {8,7,6,9,5,8};
        Solution tool = new Solution();
        boolean result = tool.increasingTriplet(nums);
        System.out.println(result);
    }
}
