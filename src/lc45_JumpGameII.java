import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class lc45_JumpGameII {
    static class Solution {
        public int jump(int[] nums) {
            if (nums.length < 2) return 0;
            HashMap<Integer, Integer> hashmap = new HashMap<>();
            Queue<Integer> queue = new LinkedList<>();
            int srcIndex = 0;
            int cnt = 0;
            queue.add(srcIndex);
            hashmap.put(srcIndex, cnt);
            while (!queue.isEmpty()) {
                int temp = queue.poll();
                cnt = hashmap.get(temp);
                for (int i = nums[temp]; i >= 0; i--) {
                    int next = temp + i;
                    if (next >= nums.length - 1) return cnt + 1;
                    if (!hashmap.containsKey(next)) {
                        hashmap.put(next, cnt + 1);
                        queue.add(next);
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution tool = new Solution();
        int result = tool.jump(nums);
        System.out.println(result);
    }
}
