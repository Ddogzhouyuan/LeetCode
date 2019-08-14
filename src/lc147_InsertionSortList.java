import static com.SinglyListNodeUtil.*;

public class lc147_InsertionSortList {
    static class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            ListNode cur = head;
            ListNode prev = dummy;
            ListNode next;
            while (cur != null) {
                next = cur.next;
                while (prev.next != null && prev.next.val < cur.val) {
                    prev = prev.next;
                }
                cur.next = prev.next;
                prev.next = cur;
                prev = dummy;
                cur = next;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[4,2,1,3]");
        Solution tool = new Solution();
        ListNode result = tool.insertionSortList(head);
        prettyPrintLinkedList(result);
    }
}
