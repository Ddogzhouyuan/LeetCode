import java.util.HashMap;

public class lc1_TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            int[] result = {0, 0};
            int index;
            for (int i=0; i<nums.length; i++) {
                if (hashmap.containsKey(nums[i])) {
                    result[0] = hashmap.get(nums[i]);
                    result[1] = i;
                    return result;
                } else {
                    hashmap.put(target - nums[i], i);
                }
            }
            return result;
        }
    }
}
