import java.util.Arrays;

import static com.SinglyListNodeUtil.*;

public class lc23_MergekSortedLists {
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 1) {
                return lists[0];
            } else if (lists.length == 0) {
                return null;
            } else if (lists.length == 2) {
                return merge(lists[0], lists[1]);
            }
//            ListNode temp = lists[0];
//            for (int i = 1; i < lists.length; i++) {
//                temp = merge(temp, lists[i]);
//            }
            int mid = lists.length / 2;
            ListNode[] left = Arrays.copyOfRange(lists, 0, mid);
            ListNode[] right = Arrays.copyOfRange(lists, mid, lists.length);
            ListNode leftresult = mergeKLists(left);
            ListNode rightresult = mergeKLists(right);
            return merge(leftresult,rightresult);
        }

        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;

            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    cur.next = head1;
                    head1 = head1.next;
                } else {
                    cur.next = head2;
                    head2 = head2.next;
                }
                cur = cur.next;
            }
            cur.next = head1 == null ? head2 : head1;
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = stringToListNode("[1,4,5]");
        ListNode head2 = stringToListNode("[1,3,4]");
        ListNode head3 = stringToListNode("[2,6]");
        ListNode[] lists = {head1, head2, head3};
        Solution tool = new Solution();
        ListNode result = tool.mergeKLists(lists);
        prettyPrintLinkedList(result);
    }
}
