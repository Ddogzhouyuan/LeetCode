public class lc33_SearchinRotatedSortedArray {
    static class Solution {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) return -1;
            int pivot = 0;
            int result = -1;
            int minIndex = 0;

            minIndex = minIndexSearch(nums, 0, nums.length - 1);
            pivot = minIndex;
            if (pivot > 0) pivot -= 1;


            if (nums[minIndex] > target) {
                return -1;
            }
            else if (minIndex > 0 && nums[0] <= target && nums[pivot] >= target) {
                result = binarySearch(nums, 0, pivot, target);
            } else if (nums[nums.length - 1] >= target) {
                result = binarySearch(nums, minIndex, nums.length - 1, target);
            } else {
                return result;
            }
            return result;
        }

        public int binarySearch(int[] nums, int i, int j, int target) {
            if (i > j) return -1;

            int mid = i + (j - i) / 2;
            if (nums[mid] > target) {
                return binarySearch(nums, i, mid - 1, target);
            }
            if (nums[mid] < target) {
                return binarySearch(nums, mid + 1, j, target);
            }
            return mid;
        }


        public int minIndexSearch(int[] nums, int i, int j) {
            if (i == j) return i;

            if (i + 1 == j) {
                if (nums[i] < nums[j]) {
                    return i;
                } else {
                    return j;
                }
            }

            int mid = i + (j - i) / 2;
            int temp = nums[minIndexSearch(nums, i, mid)] < nums[minIndexSearch(nums, mid + 1, j)] ? minIndexSearch(nums, i, mid) : minIndexSearch(nums, mid + 1, j);

            return temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0};
        int target = 0;
        Solution tool = new Solution();
        int result = tool.search(nums, target);
        System.out.println(result);
    }
}
