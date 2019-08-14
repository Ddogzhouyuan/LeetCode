import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class lc324_WiggleSortII {
    static class Solution {
        public void wiggleSort(int[] nums) {
            PriorityQueue<Integer> largeQueue = new PriorityQueue<>();
            PriorityQueue<Integer> smallQueue = new PriorityQueue<>();
            PriorityQueue<Integer> largeQueue_temp = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> smallQueue_temp = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < nums.length; i++) {
                largeQueue_temp.offer(nums[i]);
                smallQueue.offer(largeQueue_temp.poll());
                if (largeQueue_temp.size() < smallQueue.size()) {
                    largeQueue_temp.offer(smallQueue.poll());
                }
            }
            while (!smallQueue.isEmpty()) smallQueue_temp.offer(smallQueue.poll());
            int tag = 1;
            for (int i = 0; i < nums.length; i++) {
                if (tag == 1) {
                    nums[i] = largeQueue_temp.poll();
                    tag = -1;
                } else {
                    nums[i] = smallQueue_temp.poll();
                    tag = 1;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        Solution tool = new Solution();
        tool.wiggleSort(nums);
    }
}
