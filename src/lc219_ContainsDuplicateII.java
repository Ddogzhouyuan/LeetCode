import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lc219_ContainsDuplicateII {
    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer, List<Integer>> hashmap = new HashMap<>();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (hashmap.containsKey(nums[i])) {
                    temp = hashmap.get(nums[i]);
                    temp.add(i);
                    hashmap.put(nums[i], temp);
                } else {
                    temp = new ArrayList<>();
                    temp.add(i);
                    hashmap.put(nums[i], temp);
                }
            }
            boolean result = false;
            for (int key: hashmap.keySet()) {
                temp = hashmap.get(key);
                if (temp.size() > 1) {
                    for (int j = 0; j < temp.size() - 1; j++) {
                        if (temp.get(j + 1) - temp.get(j) <= k) {
                            return true;
                        }
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 3;
        Solution tool = new Solution();
        boolean result = tool.containsNearbyDuplicate(nums, k);
        System.out.println(result);
    }
}
