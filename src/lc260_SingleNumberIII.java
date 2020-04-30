public class lc260_SingleNumberIII {
    static class Solution {
        public int[] singleNumber(int[] nums) {
            int xor = 0;
            for (int num: nums) {
                xor ^= num;
            }
            int k = 0;
            while (((xor >> k) & 1) != 1) {
                k++;
            }
            int n1 = 0;
            for (int num: nums) {
                if (((num >> k) & 1) == 1) {
                    n1 ^= num;
                }
            }
            return new int[]{n1, xor ^ n1};
        }
    }
}
