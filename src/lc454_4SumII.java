import java.util.HashMap;
import java.util.Map;

public class lc454_4SumII {
    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int a: A) {
                for (int b: B) {
                    int s = a + b;
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
            }
            int result = 0;
            for (int c: C) {
                for (int d: D) {
                    int s = -c-d;
                    result += map.getOrDefault(s, 0);
                }
            }
            return result;
        }
    }
}
