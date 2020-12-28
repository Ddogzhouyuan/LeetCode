package LeetCode_CN;

import java.util.HashMap;
import java.util.Map;

public class lc167_TwoSumIIInputarrayissorted {
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                int temp = target - numbers[i];
                if (map.keySet().contains(temp)) {
                    return new int[]{map.get(temp), i + 1};
                } else {
                    map.put(numbers[i], i + 1);
                }
            }
            return new int[2];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        Solution tool = new Solution();
        int[] result = tool.twoSum(numbers, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
