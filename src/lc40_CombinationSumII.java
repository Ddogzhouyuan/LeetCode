import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc40_CombinationSumII {
    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if (candidates == null || candidates.length == 0) return result;
            Arrays.sort(candidates);
            List<Integer> temp_result = new ArrayList<>();
            backtrack(result, temp_result, candidates, target, 0);
            return result;
        }

        public void backtrack(List<List<Integer>> result, List<Integer> temp_result, int[] candidates, int remain, int start) {
            if (remain < 0) return;
            if (remain == 0) {
                boolean tag = result.contains(temp_result);
                if (!tag) {
                    result.add(new ArrayList<>(temp_result));
                }
            } else {
                for (int i = start; i < candidates.length; i++) {
                    temp_result.add(candidates[i]);
                    backtrack(result, temp_result, candidates, remain - candidates[i], i + 1);
                    temp_result.remove(temp_result.size() - 1);
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        Solution tool = new Solution();
        List<List<Integer>> result = tool.combinationSum2(nums, target);
        for (List<Integer> i: result) {
            System.out.println(i.toString());
        }
    }
}
