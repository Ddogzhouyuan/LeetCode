public class lc413_ArithmeticSlices {
    class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            int cur = 0;
            int sum = 0;
            for (int i = 2; i < A.length; i++) {
                if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                    cur += 1;
                    sum += cur;
                } else {
                    cur = 0;
                }
            }
            return sum;
        }
    }
}
