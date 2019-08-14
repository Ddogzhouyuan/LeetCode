import java.util.Arrays;

public class lc283_MoveZeroes {
    static class Solution {
        public void moveZeroes(int[] nums) {
            int idx = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if (idx == i) {
                        idx++;
                    } else {
                        nums[idx] = nums[i];
                        nums[i] = 0;
                        idx++;
                    }
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,0,3,0,12};
        Solution tool = new Solution();
        tool.moveZeroes(nums);
    }
}
