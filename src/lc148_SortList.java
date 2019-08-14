import static com.SinglyListNodeUtil.*;

public class lc148_SortList {
    static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode rightpart = slow.next;
            slow.next = null;
            ListNode result = merge(sortList(head), sortList(rightpart));
            return result;
        }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    cur.next = head1;
                    head1 = head1.next;
                } else {
                    cur.next = head2;
                    head2 = head2.next;
                }
                cur = cur.next;
            }
            cur.next = head1 == null ? head2 : head1;
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[4,3,1,2]");
        Solution tool = new Solution();
        ListNode sortL = tool.sortList(head);
        prettyPrintLinkedList(sortL);
    }
}
