import static com.SinglyListNodeUtil.*;

public class lc83_RemoveDuplicatesfromSortedList {
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode prev = head;
            ListNode cur = head;
            while (cur != null && cur.next != null) {
                cur = cur.next;
                if (cur.val > prev.val) {
                    prev = prev.next;
                } else {
                    prev.next = cur.next;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,1,1,2,3,4,4,5]");
        Solution tool = new Solution();
        ListNode result = tool.deleteDuplicates(head);
        prettyPrintLinkedList(result);
    }
}
