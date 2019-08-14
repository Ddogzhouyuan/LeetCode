public class lc6_ZigZagConversion {
    static class Solution {
        public String convert(String s, int numRows) {
            if (s.length() <= 1 || numRows == 1 || s == null) return s;
            StringBuilder[] sb = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) sb[i] = new StringBuilder();
            int i = 0, range = 2 * numRows - 2;
            while (i < s.length()) {
                if (i % range < numRows) sb[i % range].append(s.charAt(i));
                else sb[range - (i % range)].append(s.charAt(i));
                i++;
            }
            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < numRows; j++) ans.append(sb[j]);
            return ans.toString();
        }
    }
}
