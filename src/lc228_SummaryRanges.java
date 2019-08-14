import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc228_SummaryRanges {
    static class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> result = new LinkedList<>();
            if (nums.length < 1 || nums == null) return result;
            if (nums.length == 1) {
                result.add(String.valueOf(nums[0]));
                return result;
            }
            int start = 0;
            int end = 0;
            String temp = "";
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) continue;
                end = i;
                if (nums[end] == nums[end - 1] + 1) {
                    if (i == nums.length - 1) {
                        temp = String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]);
                        result.add(temp);
                    }
                    continue;
                } else {
                    if (start == end - 1) {
                        temp = String.valueOf(nums[start]);
                    } else {
                        temp = String.valueOf(nums[start]) + "->" + String.valueOf(nums[end - 1]);
                    }
                    result.add(temp);
                    start = end;
                }
                if (start == nums.length - 1) {
                    temp = String.valueOf(nums[start]);
                    result.add(temp);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        Solution tool = new Solution();
        List<String> result = tool.summaryRanges(nums);
        String[] resStr = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resStr[i] = result.get(i);
        }
        System.out.println(Arrays.toString(resStr));
    }
}
