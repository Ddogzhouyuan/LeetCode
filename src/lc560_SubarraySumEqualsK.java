import java.util.HashMap;
import java.util.Map;

public class lc560_SubarraySumEqualsK {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int sum = 0;
            int result = 0;
            Map<Integer, Integer> preSum = new HashMap<>();
            preSum.put(0, 1);
            for (int num: nums) {
                sum += num;
                result += preSum.getOrDefault(sum - k, 0);
                preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
            }
            return result;
        }
    }
}
