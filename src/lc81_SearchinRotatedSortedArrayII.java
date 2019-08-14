public class lc81_SearchinRotatedSortedArrayII {
    static class Solution {
        public boolean search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;

            while (l <= r) {
                while (l < r && nums[l] == nums[l + 1]) l++;
                while (l < r && nums[r] == nums[r - 1]) r--;
                int mid = l + (r - l) / 2;

                if (nums[mid] == target) return true;

                // there exists rotation; the middle element is in the left part of the PIVOT
                if (nums[mid] > nums[r]) {
                    if (target < nums[mid] && target >= nums[l]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                // there exists rotation; the middle element is in the right part of the PIVOT
                else if (nums[mid] < nums[l]) {
                    if (target > nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                // there is no rotation; just like normal binary search
                else {
                    if (target > nums[mid]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        Solution tool = new Solution();
        boolean result = tool.search(nums, target);
        System.out.println(result);
    }
}
