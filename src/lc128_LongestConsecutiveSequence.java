import java.util.HashSet;

public class lc128_LongestConsecutiveSequence {
    static class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            HashSet<Integer> hashset = new HashSet<>();
            for (int i = 0; i < nums.length; i++) hashset.add(nums[i]);

            int longest = 0;

            for (int i = 0; i < nums.length; i++) {
                if (!hashset.contains(nums[i] - 1)) {
                    int y = nums[i] + 1;
                    while (hashset.contains(y)) y++;
                    longest = Math.max(longest, y - nums[i]);
                }
            }
            return longest;
        }
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2,2,2};
        Solution tool = new Solution();
        int result = tool.longestConsecutive(nums);
        System.out.println(result);
    }
}
