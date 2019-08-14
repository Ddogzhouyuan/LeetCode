import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc90_SubsetsII {
    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp_result = new ArrayList<>();
            Arrays.sort(nums);
            if (nums == null || nums.length == 0) {
                result.add(temp_result);
                return result;
            }
            backtrack(result, temp_result, nums, 0);
            return result;
        }

        public void backtrack(List<List<Integer>> result, List<Integer> temp_result, int nums[], int start) {
            result.add(new ArrayList<>(temp_result));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i - 1] == nums[i]) continue;
                temp_result.add(nums[i]);
                backtrack(result, temp_result, nums, i + 1);
                temp_result.remove(temp_result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        Solution tool = new Solution();
        List<List<Integer>> result = tool.subsetsWithDup(nums);
        for (List i: result) {
            System.out.println(i.toString());
        }
    }
}
