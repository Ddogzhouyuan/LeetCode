import static com.SinglyListNodeUtil.*;

public class lc19_RemoveNthNodeFromEndofList {
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode fast = dummy;
            ListNode slow = dummy;
            while (n > 0) {
                fast = fast.next;
                n--;
            }
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,2,3,4,5]");
        int n = 2;
        Solution tool = new Solution();
        ListNode result = tool.removeNthFromEnd(head, n);
        prettyPrintLinkedList(result);
    }
}
