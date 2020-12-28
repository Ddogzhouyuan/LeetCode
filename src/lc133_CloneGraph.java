import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc133_CloneGraph {

// Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            Map<Integer, Node> processed = new HashMap<>();
            return clone(node, processed);
        }

        private Node clone(Node node, Map<Integer, Node> processed) {
            Node root = new Node(node.val, new ArrayList<>());
            processed.put(root.val, root);
            for (Node n: node.neighbors) {
                if (processed.containsKey(n.val)) {
                    root.neighbors.add(processed.get(n.val));
                } else {
                    root.neighbors.add(clone(n, processed));
                }
            }
            return root;
        }
    }
}
