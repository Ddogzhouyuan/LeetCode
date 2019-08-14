import java.util.ArrayList;
import java.util.List;

public class lc229_MajorityElementII {
    static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> result = new ArrayList<>();
            if (nums == null || nums.length == 0) return result;
            int num1 = 0;
            int cnt1 = 0;
            int num2 = 1;
            int cnt2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == num1) {
                    cnt1++;
                } else if (nums[i] == num2) {
                    cnt2++;
                } else if (cnt1 == 0) {
                    num1 = nums[i];
                    cnt1 = 1;
                } else if (cnt2 == 0) {
                    num2 = nums[i];
                    cnt2 = 1;
                } else {
                    cnt1--;
                    cnt2--;
                }
            }
            cnt1 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (num1 == nums[i]) cnt1++;
            }
            cnt2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (num2 == nums[i]) cnt2++;
            }
            if (cnt1 > nums.length / 3) result.add(num1);
            if (cnt2 > nums.length / 3) result.add(num2);
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        Solution tool = new Solution();
        List<Integer> result = tool.majorityElement(nums);
        System.out.println(result.toString());
    }
}
