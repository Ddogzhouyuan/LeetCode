import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lc354_RussianDollEnvelopes {
    static class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length != 2) return 0;
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) {
                        return o2[1] - o1[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            });
            int[] tails = new int[envelopes.length];

            int result = 0;
            for (int[] envelope : envelopes) {
                int l = 0, r = result;
                while (l != r) {
                    int mid = l + (r - l) / 2;
                    if (tails[mid] < envelope[1]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tails[l] = envelope[1];
                if (l == result) result++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[][] evenlopes = {{5,4}, {6,4}, {6,7}, {2,3}};
        Solution tool = new Solution();
        int result = tool.maxEnvelopes(evenlopes);
        System.out.println(result);
    }
}
