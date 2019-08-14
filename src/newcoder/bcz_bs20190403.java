package newcoder;

import com.SinglyListNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bcz_bs20190403 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp_result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(temp_result);
            return result;
        }
        backtrack(result, temp_result, nums);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> temp_result, int[] nums) {
        if (temp_result.size() == nums.length) result.add(new ArrayList<>(temp_result));
        for (int i = 0; i < nums.length; i++) {
            if (temp_result.contains(nums[i])) continue;
            temp_result.add(nums[i]);
            backtrack(result, temp_result, nums);
            temp_result.remove(temp_result.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(sc.nextLine());
        }
        Arrays.sort(nums);
        List<List<Integer>> result = permute(nums);
        for (List i: result) {
            String temp = "";
            for (int j = 0; j < n; j++) {
                temp += String.valueOf(i.get(j));
            }
            System.out.println(temp);
        }
    }
}
