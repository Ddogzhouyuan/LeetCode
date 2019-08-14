import static com.SinglyListNodeUtil.*;

public class lc24_SwapNodesinPairs_recur {
    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            /* head->n1->n2->... => head->n2->n1->... */
            ListNode n1 = head.next;
            ListNode n2 = swapPairs(head.next.next);
            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,2,3,4,5]");
        Solution tool = new Solution();
        ListNode result = tool.swapPairs(head);
        prettyPrintLinkedList(result);
    }
}
