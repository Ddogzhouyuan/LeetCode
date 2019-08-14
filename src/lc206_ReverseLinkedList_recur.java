import static com.SinglyListNodeUtil.*;

public class lc206_ReverseLinkedList_recur {
    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode reverse = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return reverse;

        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,2,3,4,5]");
        Solution tool = new Solution();
        ListNode result = tool.reverseList(head);
        prettyPrintLinkedList(result);
    }
}
