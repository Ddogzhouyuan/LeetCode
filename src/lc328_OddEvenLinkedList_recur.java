import static com.SinglyListNodeUtil.*;

public class lc328_OddEvenLinkedList_recur {
    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head.next == null || head.next.next == null) {
                return head;
            }
            ListNode even = head.next;
            ListNode odd = oddEvenList(head.next.next);
            head.next = even.next;
            even.next = odd.next;
            odd.next = even;
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
