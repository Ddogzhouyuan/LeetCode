import java.util.LinkedList;
import java.util.Queue;

public class lc116_PopulatingNextRightPointersinEachNode {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    static class Solution {
        public Node connect(Node root) {
            if (root == null) return root;
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            int depth = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                depth++;
                while (size > 0) {
                    Node cur = queue.poll();
                    size--;
                    if (size > 0) {
                        Node next = queue.peek();
                        cur.next = next;
                    } else {
                        Node next = null;
                        cur.next = next;
                    }
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                }

            }

            return root;
        }
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.val = 1;
        root.left = new Node();
        root.left.val = 2;
        root.right = new Node();
        root.right.val = 3;
        root.left.left = new Node();
        root.left.left.val = 4;
        root.left.right = new Node();
        root.left.right.val = 5;
        root.right.left = new Node();
        root.right.left.val = 6;
        root.right.right = new Node();
        root.right.right.val = 7;

        Solution tool = new Solution();
        tool.connect(root);

    }

}
