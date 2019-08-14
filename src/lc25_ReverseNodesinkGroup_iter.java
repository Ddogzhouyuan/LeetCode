import static com.SinglyListNodeUtil.*;

public class lc25_ReverseNodesinkGroup_iter {
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null || k == 1) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode begin = dummy;
            int i = 0;
            while (head != null) {
                i++;
                if (i % k == 0) {
                    begin = reverse(begin, head.next);
                    head = begin.next;
                } else {
                    head = head.next;
                }
            }
            return dummy.next;
        }

        public ListNode reverse(ListNode begin, ListNode end) {
            ListNode cur = begin.next;
            ListNode next, first;
            ListNode prev = begin;
            first = cur;
            while (cur != end) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            begin.next = prev;
            first.next = cur;
            return first;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,2,3,4,5]");
        int k = 3;
        Solution tool = new Solution();
        ListNode result = tool.reverseKGroup(head, k);
        prettyPrintLinkedList(result);
    }
}
