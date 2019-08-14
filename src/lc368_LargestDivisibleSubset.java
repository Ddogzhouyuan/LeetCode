import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc368_LargestDivisibleSubset {
    static class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            List<Integer> result = new ArrayList<>();
            if (nums.length == 0 || nums == null) return result;
            if (nums.length == 1) {
                result.add(nums[0]);
                return result;
            }

            Arrays.sort(nums);
            int[] dp = new int[nums.length];
            int[] parent = new int[nums.length];
            Arrays.fill(parent, -1);
            int largest = 0;
            int largestAt = 0;

            dp[0] = 1;
            for (int j = 0; j < dp.length; j++) {
                dp[j] = 1;
                for (int i = j - 1; i >= 0; i--) {
                    if (nums[j] % nums[i] == 0 && dp[j] < dp[i] + 1) {
                        dp[j] = dp[i] + 1;
                        parent[j] = i;
                    }
                }

                if (dp[j] > largest) {
                    largest = dp[j];
                    largestAt = j;
                }
            }

            for (int i = 0; i < largest; i++) {
                result.add(0, nums[largestAt]);
                largestAt = parent[largestAt];
            }

            return result;

        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,8};
        Solution tool = new Solution();
        List<Integer> result = tool.largestDivisibleSubset(nums);
        System.out.println(result.toString());
    }

}
