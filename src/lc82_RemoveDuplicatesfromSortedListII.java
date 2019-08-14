import static com.SinglyListNodeUtil.*;

public class lc82_RemoveDuplicatesfromSortedListII {
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = head;
            ListNode prev = dummy;
            while (cur != null) {
                if (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                    continue;
                }
                if (prev.next == cur) {
                    prev = cur;
                } else {
                    prev.next = cur.next;
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,1]");
        Solution tool = new Solution();
        ListNode result = tool.deleteDuplicates(head);
        prettyPrintLinkedList(result);
    }
}
