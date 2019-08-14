import java.util.Arrays;
import java.util.Collections;

public class lc274_H_Index {
    static class Solution {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int[] nums = new int[citations.length];
            for (int i = 0; i < citations.length; i++) {
                int index = citations.length - 1 - i;
                nums[i] = citations[index];
            }
            int hindex_old = 0;
            int hindex_new = 0;
            for (int i = 0; i < citations.length; i++) {
                if (nums[i] < i + 1) {
                    hindex_new = nums[i];
                } else {
                    hindex_new = i + 1;
                }
                if (hindex_new > hindex_old) {
                    hindex_old = hindex_new;
                }
            }
            return hindex_old;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3};
        Solution tool = new Solution();
        int result = tool.hIndex(nums);
        System.out.println(result);
    }
}
