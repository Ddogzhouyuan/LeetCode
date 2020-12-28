package LeetCode_CN;

import com.SinglyListNodeUtil.*;

import java.util.HashSet;
import java.util.Set;

public class lc_02_01_RemoveDuplicateNodeLCCI {
    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null) {
                return null;
            }
            Set<Integer> set = new HashSet<>();
            ListNode pre = head;
            ListNode curr = head.next;
            set.add(head.val);
            while (curr != null) {
                if (set.contains(curr.val)) {
                    pre.next = curr.next;
                    curr = curr.next;
                } else {
                    set.add(curr.val);
                    pre = curr;
                    curr = curr.next;
                }
            }
            return head;
        }
    }
}
