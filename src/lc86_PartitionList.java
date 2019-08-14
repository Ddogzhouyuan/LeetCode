import static com.SinglyListNodeUtil.*;

public class lc86_PartitionList {
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode small = new ListNode(0);
            ListNode large = new ListNode(0);
            ListNode cur_small = small;
            ListNode cur_large = large;
            ListNode cur = head;
            while (cur != null) {
                if (cur.val < x) {
                    cur_small.next = new ListNode(cur.val);
                    cur_small = cur_small.next;
                } else {
                    cur_large.next = new ListNode(cur.val);
                    cur_large = cur_large.next;
                }
                cur = cur.next;
            }
            cur_small.next = large.next;
            return small.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,4,3,2,5,2]");
        int x = 0;
        Solution tool = new Solution();
        ListNode result = tool.partition(head, x);
        prettyPrintLinkedList(result);
    }
}
