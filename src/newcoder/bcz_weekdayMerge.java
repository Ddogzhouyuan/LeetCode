package newcoder;

import java.util.Arrays;
import java.util.Scanner;

public class bcz_weekdayMerge {
    public static String weekdayMerge(int[] nums) {
        int start = 0;
        int end = 0;
        StringBuilder sb = new StringBuilder();
        while (end < nums.length - 1) {
            end++;
            if (nums[end - 1] == nums[end] - 1) {
                continue;
            } else if (end - 1 - start >= 2) {
                sb.append(String.valueOf(nums[start]) + "-" + String.valueOf(nums[end - 1]));
                sb.append(" ");
                start = end;
            } else {
                while (start < end) {
                    sb.append(String.valueOf(nums[start++]));
                    sb.append(" ");
                }
            }
        }
        if (end - start >= 2) {
            sb.append(String.valueOf(nums[start]) + "-" + String.valueOf(nums[end]));
            sb.append(" ");
        } else {
            while (start <= end) {
                sb.append(String.valueOf(nums[start++]));
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strs = sc.nextLine().split(" ");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(nums);
        String result = weekdayMerge(nums);
        System.out.println(result);
    }
}
