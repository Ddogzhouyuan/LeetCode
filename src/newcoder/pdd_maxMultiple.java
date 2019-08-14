package newcoder;

import java.util.Scanner;

public class pdd_maxMultiple {
    public static long getMaxMulti(long[] nums) {
        int n = nums.length;
        long max1 = 0, max2 = 0, max3 = 0, min1 = 0, min2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                if (nums[i] > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = nums[i];
                } else if (nums[i] > max2) {
                    max3 = max2;
                    max2 = nums[i];
                } else if (nums[i] > max3) {
                    max3 = nums[i];
                } else if (nums[i] < min1) {
                    min2 = min1;
                    min1 = nums[i];
                } else if (nums[i] < min2) {
                    min2 = nums[i];
                }
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] A = new long[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextLong();
        }
        long result = getMaxMulti(A);
        System.out.println(result);
    }
}
