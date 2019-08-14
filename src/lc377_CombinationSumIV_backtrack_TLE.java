import java.util.ArrayList;
import java.util.List;

public class lc377_CombinationSumIV_backtrack_TLE {
    static class Solution {
        public int combinationSum4(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if (target == 0) return 0;
            List<Integer> temp_result = new ArrayList<>();
            backtrack(result, temp_result, nums, target, 0);
//            for (List i: result) System.out.println(i.toString());
            return result.size();
        }

        public void backtrack(List<List<Integer>> result, List<Integer> temp_result, int[] nums, int target, int start) {
            if (target < 0) return;
            for (int i = start; i < nums.length; i++) {
                temp_result.add(nums[i]);
                backtrack(result, temp_result, nums, target - nums[i], start);
                temp_result.remove(temp_result.size() - 1);
            }
            if (target == 0 && !result.contains(temp_result)) {
                result.add(new ArrayList<>(temp_result));
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        Solution tool = new Solution();
        int result = tool.combinationSum4(nums, target);
        System.out.println(result);
    }
}
