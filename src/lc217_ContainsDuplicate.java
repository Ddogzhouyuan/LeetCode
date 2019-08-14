import java.util.HashSet;

public class lc217_ContainsDuplicate {
    static class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> hashset = new HashSet<>();
            for (int i = 0; i < nums.length; i++) hashset.add(nums[i]);
            return !(hashset.size() == nums.length);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution tool = new Solution();
        boolean result = tool.containsDuplicate(nums);
        System.out.println(result);
    }
}
