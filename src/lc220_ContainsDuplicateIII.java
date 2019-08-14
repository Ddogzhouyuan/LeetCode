
public class lc220_ContainsDuplicateIII {
    static class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            boolean result = false;
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if ((nums[i] >= Integer.MAX_VALUE && nums[j] < 0) || (nums[j] >= Integer.MAX_VALUE && nums[i] < 0)) continue;
                    if ((nums[i] <= Integer.MIN_VALUE && nums[j] > 0) || (nums[j] <= Integer.MIN_VALUE && nums[i] > 0)) continue;
                    int temp = Math.abs(nums[i] - nums[j]);
                    if (temp <= t && j - i <= k) return true;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,2147483647};
        int k = 1;
        int t = 2147483647;
        Solution tool = new Solution();
        boolean result = tool.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(result);
    }
}
