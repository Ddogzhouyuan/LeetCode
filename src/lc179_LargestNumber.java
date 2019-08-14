import java.util.Arrays;

public class lc179_LargestNumber {
    static class Solution {
        public String largestNumber(int[] nums) {
            String result = "";
            String[] nums_str = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                nums_str[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(nums_str, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
            for (int i = 0; i < nums_str.length; i++) {
                result += nums_str[i];
            }
            while (result.length() > 1 && result.charAt(0) == '0') result = result.substring(1);
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        Solution tool = new Solution();
        String result = tool.largestNumber(nums);
        System.out.println(result);
        String s1 = "300";
        String s2 = "3";
        System.out.println(s1.compareTo(s2));
    }
}
