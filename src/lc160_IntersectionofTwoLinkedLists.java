import static com.SinglyListNodeUtil.*;

public class lc160_IntersectionofTwoLinkedLists {
    public static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int n = 0, m = 0;
            ListNode cur = headA;
            while (cur != null) {
                cur = cur.next;
                n++;
            }
            cur = headB;
            while (cur != null) {
                cur = cur.next;
                m++;
            }
            ListNode cur1 = headA;
            ListNode cur2 = headB;
            if (n > m) {
                while (n > m) {
                    cur1 = cur1.next;
                    n--;
                }
            } else {
                while (m > n) {
                    cur2 = cur2.next;
                    m--;
                }
            }
            while (cur1 != null && cur2 != null && cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            if (cur1 == null || cur2 == null) return null;
            return cur1.next;
        }
    }

    public static void main(String[] args) {
        ListNode headA = stringToListNode("[0,9,1,2,4]");
        ListNode headB = stringToListNode("[3,2,4]");
        Solution tool = new Solution();
        ListNode result = tool.getIntersectionNode(headA, headB);
        prettyPrintLinkedList(result);
    }
}
