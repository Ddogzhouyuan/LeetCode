import java.util.PriorityQueue;
import java.util.Stack;

public class lc414_ThirdMaximumNumber {
    class Solution {
        public int thirdMax(int[] nums) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num: nums) {
                if (!queue.contains(num)) {
                    queue.offer(num);
                }
                if (queue.size() > 3) {
                    queue.poll();
                }
            }
            if (queue.size() == 2) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
