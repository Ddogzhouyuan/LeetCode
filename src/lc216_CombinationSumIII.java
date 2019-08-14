import java.util.ArrayList;
import java.util.List;

public class lc216_CombinationSumIII {
    static class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            if (n == 0) return result;
            List<Integer> temp_result = new ArrayList<>();
            backtrack(result, temp_result, k, n, 1);
            return result;
        }

        public void backtrack(List<List<Integer>> result, List<Integer> temp_result, int k, int remain_n, int start) {
            if (temp_result.size() == k && remain_n == 0 && !result.contains(temp_result)) {
                result.add(new ArrayList<>(temp_result));
                return;
            }
            for (int i = start; i <= 9; i++) {
                temp_result.add(i);
                backtrack(result, temp_result, k, remain_n - i, i + 1);
                temp_result.remove(temp_result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        Solution tool = new Solution();
        List<List<Integer>> result = tool.combinationSum3(k, n);
        for (List i: result) {
            System.out.println(i.toString());
        }
    }
}
