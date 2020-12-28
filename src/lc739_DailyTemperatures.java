public class lc739_DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            int[] stack = new int[T.length];
            int top = -1;
            int[] ret = new int[T.length];
            for (int i = 0; i < T.length; i++) {
                while (top > -1 && T[i] > T[stack[top]]) {
                    int idx = stack[top--];
                    ret[idx] = i - idx;
                }
                stack[++top] = i;
            }
            return ret;
        }
    }
}
