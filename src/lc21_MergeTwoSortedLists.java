import static com.SinglyListNodeUtil.*;

public class lc21_MergeTwoSortedLists {
    static class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            while (cur1 != null && cur2 != null) {
                if (cur1.val < cur2.val) {
                    cur.next = cur1;
                    cur = cur.next;
                    cur1 = cur1.next;
                } else {
                    cur.next = cur2;
                    cur = cur.next;
                    cur2 = cur2.next;
                }
            }
            if (cur1 == null) {
                cur.next = cur2;
            } else {
                cur.next = cur1;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = stringToListNode("[1,2,4]");
        ListNode l2 = stringToListNode("[1,3,4]");
        Solution tool = new Solution();
        ListNode result = tool.mergeTwoLists(l1, l2);
        prettyPrintLinkedList(result);
    }
}
