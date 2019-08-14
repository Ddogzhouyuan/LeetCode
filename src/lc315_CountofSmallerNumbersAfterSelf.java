import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc315_CountofSmallerNumbersAfterSelf {
    static class Solution {
        int[] count;
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> result = new ArrayList<>();

            count = new int[nums.length];
            int[] indexes = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                indexes[i] = i;
            }
            mergeSort(nums, indexes, 0,nums.length - 1);
            for (int i = 0; i < count.length; i++) {
                result.add(count[i]);
            }
            return result;
        }

        public void mergeSort(int[] nums, int[] indexes, int start, int end) {
            if (end <= start) {
                return;
            }
            int mid = start + (end - start) / 2;
            mergeSort(nums, indexes, start, mid);
            mergeSort(nums, indexes, mid + 1, end);
            merge(nums, indexes, start, end);
        }

        public void merge(int[] nums, int[] indexes, int start, int end) {
            int mid = start + (end - start) / 2;
            int left_index = start;
            int right_index = mid + 1;
            int rightcount = 0;
            int[] new_indexes = new int[end - start + 1];

            int sort_index = 0;
            while (left_index <= mid && right_index <= end) {
                if (nums[indexes[right_index]] < nums[indexes[left_index]]) {
                    new_indexes[sort_index] = indexes[right_index];
                    rightcount++;
                    right_index++;
                } else {
                    new_indexes[sort_index] = indexes[left_index];
                    count[indexes[left_index]] += rightcount;
                    left_index++;
                }
                sort_index++;
            }

            while (left_index <= mid) {
                new_indexes[sort_index] = indexes[left_index];
                count[indexes[left_index]] += rightcount;
                left_index++;
                sort_index++;
            }

            while (right_index <= end) {
                new_indexes[sort_index] = indexes[right_index];
                sort_index++;
                right_index++;
            }

            for (int i = start; i <= end; i++) {
                indexes[i] = new_indexes[i - start];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        Solution tool = new Solution();
        List<Integer> result = tool.countSmaller(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
