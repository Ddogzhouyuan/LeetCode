import static com.SinglyListNodeUtil.*;

public class lc24_SwapNodesinPairs {
    static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            head = dummy;
            while (head.next != null && head.next.next != null) {
                ListNode n1 = head.next;
                ListNode n2 = head.next.next;

                /* head->n1->n2->... => head->n2->n1->... */
                head.next = n2;
                n1.next = n2.next;
                n2.next = n1;
                head = n1;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,2,3,4,5]");
        Solution tool = new Solution();
        ListNode result = tool.swapPairs(head);
        prettyPrintLinkedList(result);
    }
}
