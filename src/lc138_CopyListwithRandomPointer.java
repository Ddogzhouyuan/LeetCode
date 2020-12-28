import com.SinglyListNodeUtil.*;

import java.util.HashMap;

public class lc138_CopyListwithRandomPointer {

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            Node oldHead = head;
            Node newHead = head;
            HashMap<Node, Node> map = new HashMap<>();
            while (oldHead != null) {
                newHead = new Node(oldHead.val);
                map.put(oldHead, newHead);
                oldHead = oldHead.next;
            }
            oldHead = head;
            while (oldHead != null) {
                newHead = map.get(oldHead);
                newHead.next = map.get(oldHead.next);
                newHead.random = map.get(oldHead.random);
                oldHead = oldHead.next;
            }
            return map.get(head);
        }
    }
}
