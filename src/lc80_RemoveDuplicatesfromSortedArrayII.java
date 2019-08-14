import java.util.Arrays;

public class lc80_RemoveDuplicatesfromSortedArrayII {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (j < 2 || nums[j - 2] != nums[i]) {
                    nums[j++] = nums[i];
                }
            }
//            System.out.println(Arrays.toString(nums));
            return j;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        Solution tool = new Solution();
        int result = tool.removeDuplicates(nums);
        System.out.println(result);
    }
}
