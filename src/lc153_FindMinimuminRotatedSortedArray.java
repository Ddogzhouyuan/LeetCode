public class lc153_FindMinimuminRotatedSortedArray {
    static class Solution {
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (mid - 1 >= l && mid + 1 <= r) {
                    if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1] && nums[mid + 1] <= nums[r]) {
                        r = mid - 1;
                    } else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1] && nums[mid - 1] >= nums[l]) {
                        l = mid + 1;
                    } else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                        return nums[mid];
                    } else {
                        l = mid + 1;
                    }
                } else if (mid == l && mid + 1 <= r) {
                    return Math.min(nums[mid], nums[mid + 1]);
                } else if (mid == r && mid - 1 >= l) {
                    return Math.min(nums[mid], nums[mid - 1]);
                } else {
                    return nums[mid];
                }
            }
            return nums[l];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,1};
        Solution tool = new Solution();
        int result = tool.findMin(nums);
        System.out.println(result);
    }
}
