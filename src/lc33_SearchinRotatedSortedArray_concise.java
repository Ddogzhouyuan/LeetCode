public class lc33_SearchinRotatedSortedArray_concise {
    static class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (nums[mid] == target) return mid;

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
            return -1;
        }
    }
}
