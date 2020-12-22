package LeetCode_CN;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lc215_KthLargestElementinanArray {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int num: nums) {
                queue.offer(num);
            }
            for (int i = 1; i < k; i++) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
