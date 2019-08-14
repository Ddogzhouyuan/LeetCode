import java.util.Arrays;

public class lc167_TwoSumIIInputarrayissorted {
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] result = new int[2];
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int v = numbers[left] + numbers[right];
                if (v == target) {
                    result[0] = left + 1;
                    result[1] = right + 1;
                    return result;
                } else if (v > target) {
                    right--;
                } else {
                    left++;
                }
            }
            result[0] = left + 1;
            result[1] = right + 1;
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution tool = new Solution();
        int[] result = tool.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
