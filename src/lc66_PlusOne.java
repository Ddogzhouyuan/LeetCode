import java.util.Arrays;

public class lc66_PlusOne {
    static class Solution {
        public int[] plusOne(int[] digits) {
            int n = digits.length;
            for (int i = n - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }

                digits[i] = 0;
            }

            int[] newNumber = new int[n + 1];
            newNumber[0] = 1;
            return newNumber;
        }
    }

    public static void main(String[] args) {
        int[] digits = {1,2,3,5,6};
        Solution tool = new Solution();
        int[] result = tool.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
}
