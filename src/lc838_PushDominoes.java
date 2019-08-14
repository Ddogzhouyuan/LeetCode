import java.util.Arrays;

public class lc838_PushDominoes {
    // 'R......R' => 'RRRRRRR'
    // 'R......L' => 'RRRRLLLL' or 'RRR.LLL'
    // 'L......R' => 'L.....R'
    // 'L......L' => 'LLLLLLLL'
    static class Solution {
        public String pushDominoes(String dominoes) {
            if (dominoes == null) return null;
            dominoes = "L" + dominoes + "R";
            char[] A = dominoes.toCharArray();
            int start = 0;
            for (int end = 0; end < A.length; end++) {
                if (A[end] != '.') {
                    convert(A, start, end);
                    start = end;
                }
            }
            return String.valueOf(A).substring(1, A.length - 1);
        }

        public void convert(char[] A, int start, int end) {
            int N = end - start + 1;
            char startChar = A[start];
            char endChar = A[end];
            if (startChar == endChar) {
                for (int i = 0; i < N; i++) {
                    A[start + i] = startChar;
                }
            } else if (startChar == 'R' && endChar == 'L') {
                for (int i = 0; i < N; i++) {
                    A[start + i] = (i < N - 1 - i) ? 'R' : (i > N - 1 - i) ? 'L' : '.';
                }
            }
        }
    }

    public static void main(String[] args) {
        String dominos = "R..L..R..LR.R.R.....";
        Solution tool = new Solution();
        String result = tool.pushDominoes(dominos);
        System.out.println(result);
    }
}
