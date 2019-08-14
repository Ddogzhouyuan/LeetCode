import java.util.ArrayDeque;
import java.util.Deque;

public class lc376_WiggleSubsequence {
    static class Solution {
        public int wiggleMaxLength(int[] nums) {
            Deque<Integer> deque = new ArrayDeque<Integer>();
            int tag = 0;
            for (int i = 0; i < nums.length; i++) {
                if (deque.isEmpty()) {
                    deque.add(nums[i]);
                } else if (deque.peekLast() == nums[i]) {
                    continue;
                } else if (deque.size() == 1) {
                    if (deque.peekLast() > nums[i]) {
                        tag = -1;
                        deque.add(nums[i]);
                    } else {
                        tag = 1;
                        deque.add(nums[i]);
                    }
                }
                if (deque.size() >= 2 && deque.peekLast() != nums[i]) {
                    if (tag == -1) {
                        if (nums[i] > deque.peekLast()) {
                            deque.add(nums[i]);
                            tag = 1;
                        } else {
                            deque.pollLast();
                            deque.add(nums[i]);
                        }
                    } else {
                        if (nums[i] < deque.peekLast()) {
                            deque.add(nums[i]);
                            tag = -1;
                        } else {
                            deque.pollLast();
                            deque.add(nums[i]);
                        }
                    }
                }
            }
            return deque.size();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        Solution tool = new Solution();
        int result = tool.wiggleMaxLength(nums);
        System.out.println(result);
    }
}
