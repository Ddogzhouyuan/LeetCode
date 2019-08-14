import java.util.HashSet;

public class lc287_FindtheDuplicateNumber {
    static class Solution {
        public int findDuplicate(int[] nums) {
            HashSet<Integer> hashset = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (hashset.contains(nums[i])) {
                    return nums[i];
                } else {
                    hashset.add(nums[i]);
                }
            }
            return nums[nums.length - 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        Solution tool = new Solution();
        int result = tool.findDuplicate(nums);
        System.out.println(result);
    }
}
