import static com.SinglyListNodeUtil.*;

public class lc328_OddEvenLinkedList {
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenhead = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenhead;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,2,3,4,5]");
        Solution tool = new Solution();
        ListNode result = tool.oddEvenList(head);
        prettyPrintLinkedList(result);
    }
}
