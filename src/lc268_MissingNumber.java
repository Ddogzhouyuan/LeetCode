public class lc268_MissingNumber {
    static class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int expectSum = 0;
            for (int i = 0; i <= n; i++) {
                expectSum += i;
            }
            int realSum = 0;
            for (int i = 0; i < n; i++) {
                realSum += nums[i];
            }
            return expectSum - realSum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 1};
        Solution tool = new Solution();
        int result = tool.missingNumber(nums);
        System.out.println(result);
    }
}
