import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc315_CountofSmallerNumbersAfterSelf_TLE {
    static class Solution {
        public List<Integer> countSmaller(int[] nums) {
//            int[] numsSort = Arrays.copyOfRange(nums, 0, nums.length);
            List<Integer> result = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                int[] numsSort = Arrays.copyOfRange(nums, i, nums.length);
                Arrays.sort(numsSort);
                int temp = binarySearch(numsSort, 0, numsSort.length - 1, nums[i]);
                result.add(temp);
            }
            return result;
        }

        public int binarySearch(int[] nums, int l, int h, int target) {
            if (l > h) return -1;
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                while (mid >= l && nums[mid] == target) {
                    mid--;
                }
                return mid + 1;
            } else if (nums[mid] < target) {
                return binarySearch(nums, mid + 1, h, target);
            } else {
                return binarySearch(nums, l, mid - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        Solution tool = new Solution();
        List<Integer> result = tool.countSmaller(nums);
        System.out.println(result.toString());
    }
}
