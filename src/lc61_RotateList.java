import static com.SinglyListNodeUtil.*;

public class lc61_RotateList {
    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) {
                return head;
            }
            int count = 0;
            ListNode cur = head;
            while (cur != null) {
                count++;
                cur = cur.next;
            }
            int new_k = k % count;
            if (new_k == 0) return head;
            cur = head;
            for (int i = 1; i < count - new_k; i++) {
                cur = cur.next;
            }
            ListNode rightpart = cur.next;
            cur.next = null;
            ListNode cur2 = rightpart;
            while (cur2.next != null) {
                cur2 = cur2.next;
            }
            cur2.next = head;
            return rightpart;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,2]");
        int k = 2;
        Solution tool = new Solution();
        ListNode result = tool.rotateRight(head, k);
        prettyPrintLinkedList(result);
    }
}
