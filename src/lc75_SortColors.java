import java.util.Arrays;

public class lc75_SortColors {
    static class Solution {
        public void sortColors(int[] nums) {
            int[] temp = new int[3];
            for (int i = 0; i < nums.length; i++) {
                temp[nums[i]] += 1;
            }
            int idx = 0;
            for (int i = 0; i < temp.length; i++) {
                int j = temp[i];
                while (j > 0) {
                    nums[idx++] = i;
                    j--;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        Solution tool = new Solution();
        tool.sortColors(nums);
    }
}
