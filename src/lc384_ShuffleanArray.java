import java.util.Random;

public class lc384_ShuffleanArray {
    static class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums.clone();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums.clone();
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] result = reset();

            Random rand = new Random();
            for (int i = 0; i < result.length; i++) {
                int j = rand.nextInt(result.length - i) + i;
                int tmp = result[i];
                result[i] = result[j];
                result[j] = tmp;
            }
            return result;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
