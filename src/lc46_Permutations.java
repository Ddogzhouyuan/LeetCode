import java.util.ArrayList;
import java.util.List;

public class lc46_Permutations {
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp_result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                result.add(temp_result);
                return result;
            }
            backtrack(result, temp_result, nums);
            return result;
        }

        public void backtrack(List<List<Integer>> result, List<Integer> temp_result, int[] nums) {
            if (temp_result.size() == nums.length) result.add(new ArrayList<>(temp_result));
            for (int i = 0; i < nums.length; i++) {
                if (temp_result.contains(nums[i])) continue;
                temp_result.add(nums[i]);
                backtrack(result, temp_result, nums);
                temp_result.remove(temp_result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution tool = new Solution();
        List<List<Integer>> result = tool.permute(nums);
        for (List i: result) {
            System.out.println(i.toString());
        }
    }
}
