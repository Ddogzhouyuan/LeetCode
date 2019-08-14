import static com.SinglyListNodeUtil.*;

public class lc237_DeleteNodeinaLinkedList {
    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
