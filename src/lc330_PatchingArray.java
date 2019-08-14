import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc330_PatchingArray {
    static class Solution {
        public int minPatches(int[] nums, int n) {
            int result = 0;
            long miss = 1;
            int i = 0;
//            List<Integer> temp = new LinkedList<>();
            while (miss <= n) {
                if (i < nums.length && nums[i] <= miss) {
                    miss += nums[i];
                    i++;
                } else {
                    result++;
//                    temp.add(miss);
                    miss += miss;
                }
            }
//            System.out.println(temp.toString());
            return result;
        }

        public void backtrack(List<Integer> subset_sum, int temp_result, int[] nums, int start) {
            if (temp_result > 0) subset_sum.add(temp_result);
            for (int i = start; i < nums.length; i++) {
                temp_result += nums[i];
                backtrack(subset_sum, temp_result, nums, i + 1);
                temp_result -= nums[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,31,33};
        int n = 2147483647;
        Solution tool = new Solution();
        int result = tool.minPatches(nums, n);
        System.out.println(result);
    }
}
