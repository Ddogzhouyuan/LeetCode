import static com.SinglyListNodeUtil.*;

public class lc234_PalindromeLinkedList {
    static class Solution {
        ListNode ref;
        public boolean isPalindrome(ListNode head) {
            ref = head;
            boolean result = check(head);
            return result;
        }

        public boolean check(ListNode head) {
            if (head == null) {
                return true;
            }
            boolean ans = check(head.next);
            boolean isEqual = head.val == ref.val ? true : false;
            ref = ref.next;
            return isEqual && ans;
        }
    }

    public static void main(String[] args) {
        ListNode head = stringToListNode("[1,2,2,1]");
        Solution tool = new Solution();
        boolean result = tool.isPalindrome(head);
        System.out.println(result);
    }
}
