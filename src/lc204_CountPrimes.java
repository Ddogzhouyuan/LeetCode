public class lc204_CountPrimes {
    static class Solution {
        public int countPrimes(int n) {
            boolean[] notPrime = new boolean[n];
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (notPrime[i] == false) {
                    count++;
                    for (int j = 2; i * j < n; j++) {
                        notPrime[j * i] = true;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int n = 13;
        Solution tool = new Solution();
        int result = tool.countPrimes(n);
        System.out.println(result);
    }
}
