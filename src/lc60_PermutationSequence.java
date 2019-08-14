import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc60_PermutationSequence {
    static class Solution {
        public String getPermutation(int n, int k) {
            List<Integer> numbers = new ArrayList<>();
            int[] factorial = new int[n + 1];
            StringBuilder sb = new StringBuilder();

            int sum = 1;
            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
                sum *= i;
                factorial[i] = sum;
            }

            for (int i = 1; i <= n; i++) {
                numbers.add(i);
            }

            k--;

            for (int i = 1; i <= n; i++) {
                int index = k / factorial[n - i];
                sb.append(String.valueOf(numbers.get(index)));
                numbers.remove(index);
                k -= index * factorial[n - i];
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 9;
        Solution tool = new Solution();
        String result = tool.getPermutation(n, k);
        System.out.println(result);
    }
}
