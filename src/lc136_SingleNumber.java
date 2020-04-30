public class lc136_SingleNumber {
    static class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int i: nums) {
                result ^= i;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        Solution tool = new Solution();
        int result = tool.singleNumber(nums);
        System.out.println(result);
    }
}
