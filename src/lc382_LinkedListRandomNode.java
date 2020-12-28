import com.SinglyListNodeUtil.*;

public class lc382_LinkedListRandomNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static class Solution {

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        ListNode head;

        public Solution(ListNode head) {
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            double rand = Math.random();
            if (rand == 0) {
                rand = 1;
            }
            double index = 0;
            int prev = 0;

            ListNode fast = head;
            ListNode slow = head;
            while (fast != null) {
                fast = fast.next;
                index += rand;
                if ((int) index > prev) {
                    prev = (int) index;
                    slow = slow.next;
                }
            }
            return slow.val;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
}
