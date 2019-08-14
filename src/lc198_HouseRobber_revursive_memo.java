import java.util.HashMap;

public class lc198_HouseRobber_revursive_memo {
    static class Solution {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        public int rob(int[] nums) {
            return helper(nums, nums.length - 1);
        }

        public int helper(int[] nums, int i) {
            if (i < 0) {
                return 0;
            }
            if (hashmap.containsKey(i)) {
                return hashmap.get(i);
            }
            int result = Math.max(helper(nums, i - 2) + nums[i], helper(nums, i - 1));
            hashmap.put(i, result);
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution tool = new Solution();
        int result = tool.rob(nums);
        System.out.println(result);
    }
}
