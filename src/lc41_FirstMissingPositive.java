import java.util.Arrays;
import java.util.LinkedList;

public class lc41_FirstMissingPositive {
    static class Solution {
        public int firstMissingPositive(int[] nums1) {
            int[] nums = dropDuplicates(nums1);
            Arrays.sort(nums);
            int index = binarySearchspecial(nums, 0, nums.length - 1, 0);
            if (index >= nums.length) return 1;
            if (nums[index] <= 0 && index < nums.length - 1) index++;
            if (nums[index] != 1) return 1;
            for (int i = index; i < nums.length - 1; i++) {
                if (nums[i + 1] == nums[i] + 1 || nums[i + 1] == nums[i]) {
                    continue;
                } else {
                    return nums[i] + 1;
                }
            }
            return nums[nums.length - 1] + 1;
        }

        public int[] dropDuplicates(int[] nums) {
            LinkedList<Integer> result = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (!result.contains(nums[i])) result.add(nums[i]);
            }
            int[] temp = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                temp[i] = result.get(i);
            }
            return temp;
        }

        public int binarySearchspecial(int[] nums, int i, int j, int target) {
            int mid = i + (j - i) / 2;
            if (i > j) return mid;
            if (nums[mid] < target) return binarySearchspecial(nums, mid + 1, j, target);
            if (nums[mid] > target) return binarySearchspecial(nums, i, mid - 1, target);
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,2,2,4,0,1,0,1,3};
        Solution tool = new Solution();
        int res = tool.firstMissingPositive(nums);
        System.out.println(res);
    }
}
