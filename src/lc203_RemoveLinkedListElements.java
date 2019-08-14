import static com.SinglyListNodeUtil.*;

public class lc203_RemoveLinkedListElements {
    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur != null && cur.next != null) {
                if (cur.next.val == val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,1,1,2,3,4,4,5]");
        int val = 1;
        Solution tool = new Solution();
        ListNode result = tool.removeElements(head, val);
        prettyPrintLinkedList(result);
    }
}
