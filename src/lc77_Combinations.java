import java.util.ArrayList;
import java.util.List;

public class lc77_Combinations {
    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            if (k > n) return result;
            List<Integer> temp_resul = new ArrayList<>();
            backtrack(result, temp_resul, k, n, 1);
            return result;
        }

        public void backtrack(List<List<Integer>> result, List<Integer> temp_result, int k, int n, int start) {
            if (temp_result.size() == k) {
                result.add(new ArrayList<>(temp_result));
                return;
            }
            for (int i = start; i <= n; i++) {
                temp_result.add(i);
                backtrack(result, temp_result, k, n, i + 1);
                temp_result.remove(temp_result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Solution tool = new Solution();
        List<List<Integer>> result = tool.combine(n, k);
        for (List i : result) {
            System.out.println(i.toString());
        }
    }
}
