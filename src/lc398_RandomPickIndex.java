import java.util.Random;

public class lc398_RandomPickIndex {
    static class Solution {
        int[] arr;

        public Solution(int[] nums) {
            arr = nums;
        }

        public int pick(int target) {
            Random random = new Random();
            int rand = random.nextInt(arr.length);
            if (arr[rand] != target) {
                return pick(target);
            }
            return rand;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
}
