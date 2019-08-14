import java.util.ArrayList;
import java.util.List;

public class lc78_Subsets {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp_result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                result.add(temp_result);
                return result;
            }
            backtrack(result, temp_result, nums, 0);
            return result;
        }

        public void backtrack(List<List<Integer>> result, List<Integer> temp_result, int[] nums, int start) {
            result.add(new ArrayList<>(temp_result));
            for (int i = start; i < nums.length; i++) {
                temp_result.add(nums[i]);
                backtrack(result, temp_result, nums, i + 1);
                temp_result.remove(temp_result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Solution tool = new Solution();
        List<List<Integer>> result = tool.subsets(nums);
        for (List<Integer> i: result) {
            System.out.println(i.toString());
        }
    }
}
