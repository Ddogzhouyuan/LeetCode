import static com.SinglyListNodeUtil.*;

public class lc143_ReorderList {
    static class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
//            find mid cur
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
//            reverse the rest half part 1->2->3->4->5->6 to 1->2->3->6->5->4
            ListNode pre1 = dummy;
            ListNode pre2 = slow;
            ListNode cur = pre2.next;
            while (cur.next != null) {
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = pre2.next;
                pre2.next = next;
            }

//            Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
            ListNode cur1 = pre1.next;
            ListNode cur2 = pre2.next;
            pre2.next = null;
            while (cur2 != null) {
                ListNode next1 = cur1.next;
                ListNode next2 = cur2.next;
                cur1.next = cur2;
                cur2.next = next1;
                cur1 = next1;
                cur2 = next2;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,2,3,4,5,6]");
        Solution tool = new Solution();
        tool.reorderList(head);
        prettyPrintLinkedList(head);
    }
}
