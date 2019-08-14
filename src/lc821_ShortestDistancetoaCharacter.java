import java.util.Arrays;

public class lc821_ShortestDistancetoaCharacter {
    static class Solution {
        public int[] shortestToChar(String S, char C) {
            int n = S.length();
            int[] result = new int[n];
            int pos = -n;
            for (int i = 0; i < n; i++) {
                if (S.charAt(i) == C) pos = i;
                result[i] = i - pos;
            }
            for (int i = n - 1; i >= 0; i--) {
                if (S.charAt(i) == C) pos = i;
                result[i] = Math.min(Math.abs(i - pos), result[i]);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String S = "loveleetcode";
        char C = 'e';
        Solution tool = new Solution();
        int[] result = tool.shortestToChar(S, C);
        System.out.println(Arrays.toString(result));

    }
}
