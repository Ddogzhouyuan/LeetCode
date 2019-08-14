import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lc94_BinaryTreeInorderTraversal_iterative {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            if (root == null) return result;
            Stack<TreeNode> tovisit = new Stack<>();
            TreeNode visiting = root;
            while (visiting != null || !tovisit.isEmpty()) {
                if (visiting != null) {
                    tovisit.push(visiting);
                    visiting = visiting.left;
                } else {
                    TreeNode node = tovisit.pop();
                    result.add(node.val);
                    visiting = node.right;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution tool = new Solution();
        List<Integer> result = tool.inorderTraversal(root);
        System.out.println(result.toString());
    }
}
