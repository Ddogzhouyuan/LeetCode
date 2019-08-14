public class lc162_FindPeakElement {
    static class Solution {
        public int findPeakElement(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid1 = l + (r - l) / 2;
                int mid2 = mid1 + 1;
                if (nums[mid1] < nums[mid2]) {
                    l = mid2;
                } else {
                    r = mid1;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        Solution tool = new Solution();
        int result = tool.findPeakElement(nums);
        System.out.println(result);
    }
}
