import java.util.Arrays;

public class lc34_FindFirstandLastPositionofElementinSortedArray {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) return new int[]{-1, -1};
            int result = binarySearch(nums, 0, nums.length - 1,  target);
            if (result == -1) return new int[]{-1, -1};
            int minIndex = binarySearchMinIndex(nums, 0, result, target);
            int maxIndex = binarySearchMaxIndex(nums, result, nums.length - 1, target);
            int[] finalresult = {minIndex, maxIndex};

            return finalresult;
        }

        public int binarySearch(int[] nums, int i, int j, int target) {
            if (i > j) return -1;

            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                return binarySearch(nums, mid + 1, j, target);
            }
            if (nums[mid] > target) {
                return binarySearch(nums, i, mid - 1, target);
            }
            return mid;
        }

        public int binarySearchMinIndex(int[] nums, int i ,int j, int target) {
            int mid = 0;
            while (i < j) {
                mid = i + (j - i) / 2;
                if (nums[mid] < target) {
                    i = mid + 1;
                } else {
                    j -= 1;
                }
            }
            if (nums[i] < target) i += 1;
            return i;
        }

        public int binarySearchMaxIndex(int[] nums, int i ,int j, int target) {
            int mid = 0;
            while (i < j) {
                mid = i + (j - i) / 2;
                if (nums[mid] > target) {
                    j = mid - 1;
                } else {
                    i += 1;
                }
            }
            if (nums[j] > target) j -= 1;
            return j;
        }

    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,8,8,8,10};
        int target = 10;
        Solution tool = new Solution();
        int[] result = tool.searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
