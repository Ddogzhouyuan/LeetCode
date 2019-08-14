import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc189_RotateArray {
    static class Solution {
        public void rotate(int[] nums, int k) {
            /* Time Limit Exceeded
            if (nums == null || nums.length <= 1) return;
            while (k > 0) {
                int temp1 = nums[nums.length - 1];
                for (int i = nums.length - 1; i >= 0; i--) {
                    if (i - 1 >= 0) {
                        nums[i] = nums[i - 1];
                    } else {
                        nums[i] = temp1;
                    }
                }
                k--;
            }
            */
            k = k % nums.length;
            if (nums == null || nums.length <= 1 || k == 0) return;

            int[] temp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int index = i + k >= nums.length ? i + k - nums.length  : i + k;
                temp[index] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,7,8,9};
        int k = 5;
        Solution tool = new Solution();
        tool.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
