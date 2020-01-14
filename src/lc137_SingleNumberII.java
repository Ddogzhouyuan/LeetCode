public class lc137_SingleNumberII {
    static class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                int count = 0;
                for (int j = 0; j < nums.length; j++) {
                    if ((nums[j] & (1 << i)) != 0) {
                        count++;
                    }
                }
                result |= ((count % 3) << i);
            }
            return result;
        }
    }
}
