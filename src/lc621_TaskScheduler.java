import java.util.Arrays;

public class lc621_TaskScheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] count = new int[26];
            for (char c: tasks) {
                count[c - 'A']++;
            }
            Arrays.sort(count);
            int i = 25;
            while (i > 0 && count[i] == count[25]) {
                i--;
            }
            return Math.max(tasks.length, (count[25] - 1) * (n + 1) + (25 - i));
        }
    }
}
