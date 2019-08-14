import static com.SinglyListNodeUtil.*;

public class lc92_ReverseLinkedListII {
    static class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy;
            n -= m;
            while (m > 1) {
                cur = cur.next;
                m--;
            }
            ListNode start = cur.next;
            ListNode next = null;
            // dummy-> 1 -> 2 -> 3 -> 4 -> 5
            while (n > 0) {
                next = start.next;
                start.next = next.next;
                next.next = cur.next;
                cur.next = next;
                n--;
            }
            return dummy.next;

        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,2,3,4,5]");
        int m = 2;
        int n = 4;
        Solution tool = new Solution();
        ListNode result = tool.reverseBetween(head, m, n);
        prettyPrintLinkedList(result);
    }
}
