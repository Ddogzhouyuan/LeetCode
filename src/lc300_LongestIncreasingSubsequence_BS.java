public class lc300_LongestIncreasingSubsequence_BS {
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length == 0) return 0;
            int result = 0;
            int[] tails = new int[nums.length];

            for (int item : nums) {
                int l = 0, r = result;
                while (l != r) {
                    int mid = l + (r - l) / 2;

                    if (tails[mid] < item) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tails[l] = item;
                if (l == result) result++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 8, 2, 12};
        Solution tool = new Solution();
        int result = tool.lengthOfLIS(nums);
        System.out.println(result);
    }
}
