import java.util.*;

public class lc39_CombinationSum {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            if (candidates == null || candidates.length == 0) return result;
            List<Integer> temp_result = new LinkedList<>();
            backtrack(result, temp_result, candidates, target, 0);
            return result;
        }

        public void backtrack(List<List<Integer>> result, List<Integer> temp_result, int[] candicates, int remain, int start) {
            if (remain < 0) return;
            if (remain == 0) {
                result.add(new LinkedList<>(temp_result));
            } else {
                for (int i = start; i < candicates.length; i++) {
                    temp_result.add(candicates[i]);
                    backtrack(result, temp_result, candicates, remain - candicates[i], i);
                    temp_result.remove(temp_result.size() - 1);
                }
            }

        }

    }



    public static void main(String[] args) {
        int[] candidates = {7,3,2};
        int target = 18;
        Solution tool = new Solution();
        List<List<Integer>> result = tool.combinationSum(candidates, target);
        for (List i: result) {
            System.out.println(i.toString());
        }
    }
}
