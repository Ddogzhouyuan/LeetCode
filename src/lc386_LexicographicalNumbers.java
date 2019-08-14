import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc386_LexicographicalNumbers {
    static class Solution {
        public List<Integer> lexicalOrder(int n) {
            List<Integer> res = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                dfs(i, n, res);
            }
            return res;
        }

        public void dfs(int cur, int n, List<Integer> res) {
            if (cur > n) return;
            res.add(cur);
            for (int i = 0; i < 10; i++) {
                int temp = 10 * cur + i;
                if (temp > n) return;
                dfs(temp, n, res);
            }
        }
    }

    public static void main(String[] args) {
        int n = 123123;
        Solution tool = new Solution();
        List<Integer> result = tool.lexicalOrder(n);
        System.out.println(result.toString());
    }
}
