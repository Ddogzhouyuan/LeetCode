import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc47_PermutationsII {
    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp_result = new ArrayList<>();
            Arrays.sort(nums);
            if (nums == null || nums.length == 0) return result;
            backtrack(result, temp_result, nums);
            return result;
        }

        public void backtrack(List<List<Integer>> result, List<Integer> temp_result, int[] nums) {
            if (temp_result.size() == nums.length) result.add(new ArrayList<>(temp_result));
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) continue;
                int a = CountElement(nums, nums[i]);
                int b = CountElement(convertInteger(temp_result), nums[i]);
                if (b >= a) continue;
                temp_result.add(nums[i]);
                backtrack(result, temp_result, nums);
                temp_result.remove(temp_result.size() - 1);
            }
        }

        public int[] convertInteger(List<Integer> list) {
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i).intValue();
            }
            return res;
        }

        public int CountElement(int[] nums, int target) {
            int cnt = 0;
            for (int i :nums) {
                if (i == target) cnt++;
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,1,2};
        Solution tool = new Solution();
        List<List<Integer>> result = tool.permuteUnique(nums);
        for (List i: result) {
            System.out.println(i.toString());
        }
    }
}
