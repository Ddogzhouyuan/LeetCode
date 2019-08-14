public class lc327_CountofRangeSum {
    static class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            long[] sums = new long[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
            return countWhileMergeSort(sums, 0, nums.length + 1, lower, upper);
        }

        public int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
            if (end - start <= 1) return 0;
            int mid = (start + end) / 2;
            int count = countWhileMergeSort(sums, start, mid, lower, upper) + countWhileMergeSort(sums, mid, end, lower, upper);
            int j = mid, k = mid, t = mid;
            long[] cache = new long[end - start];
            for (int i = start, r = 0; i < mid; ++i, ++r) {
                while (k < end && sums[k] - sums[i] < lower) k++;
                while (j < end && sums[j] - sums[i] <= upper) j++;
                while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
                cache[r] = sums[i];
                count += j - k;
            }
            System.arraycopy(cache, 0, sums, start, t - start);
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,5,-1};
        int lower = -2;
        int upper = 2;
        Solution tool = new Solution();
        int result = tool.countRangeSum(nums, lower, upper);
        System.out.println(result);
    }
}
