import java.util.Stack;

import static com.SinglyListNodeUtil.*;

public class lc206_ReverseLinkedList_iter {
    static class Solution {
        public ListNode reverseList(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            while (head != null) {
                stack.push(head.val);
                head = head.next;
            }
            ListNode result = new ListNode(0);
            ListNode cur = result;
            while (!stack.isEmpty()) {
                cur.next = new ListNode(stack.pop());
                cur = cur.next;
            }
            return result.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,2,3,4,5]");
        Solution tool = new Solution();
        ListNode result = tool.reverseList(head);
        prettyPrintLinkedList(result);
    }
}
