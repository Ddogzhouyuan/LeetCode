import static com.SinglyListNodeUtil.*;

public class lc206_ReverseLinkedList_iter2 {
    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head;
            ListNode prev = null;
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,2,3,4,5]");
        Solution tool = new Solution();
        ListNode result = tool.reverseList(head);
        prettyPrintLinkedList(result);
    }
}
