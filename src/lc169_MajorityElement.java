import java.util.HashMap;

public class lc169_MajorityElement {
    static class Solution {
        public int majorityElement(int[] nums) {
            if (nums.length == 1) return nums[0];
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                if (hashmap.containsKey(nums[i])) {
                    int temp_cnt = hashmap.get(nums[i]) + 1;
                    hashmap.put(nums[i], temp_cnt);
                } else {
                    hashmap.put(nums[i], 1);
                }
            }
            for (int key: hashmap.keySet()) {
                if (hashmap.get(key) > nums.length / 2) {
                    result = key;
                    break;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        Solution tool = new Solution();
        int result = tool.majorityElement(nums);
        System.out.println(result);
    }
}
