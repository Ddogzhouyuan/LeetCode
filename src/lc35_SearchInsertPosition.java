public class lc35_SearchInsertPosition {
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) {
                if (nums[0] > target) {
                    return 0;
                } else if (nums[0] < target) {
                    return 1;
                } else {
                    return 0;
                }
            }
            int index = binarySearchSpecial(nums, 0, nums.length - 1, target);
            if (index == nums.length - 1){
                if (nums[index] < target) {
                    index += 1;
                }
            }
            return index;
        }

        public int binarySearch(int[] nums, int i, int j, int target) {
            if (i > j) return -1;
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) return binarySearch(nums, mid + 1, j, target);
            if (nums[mid] > target) return binarySearch(nums, i, mid - 1, target);
            return mid;
        }

        public int binarySearchSpecial(int[] nums, int i, int j, int target) {
            int mid = 0;
            while (i < j) {
                mid = i + (j - i) / 2;
                if (nums[mid] < target) {
                    i = mid + 1;
                } else {
                    j -= 1;
                }
            }
            return i;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 2;
        Solution tool = new Solution();
        int result = tool.searchInsert(nums, target);
        System.out.println(result);
    }
}
