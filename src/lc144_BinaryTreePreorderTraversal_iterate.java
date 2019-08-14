import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lc144_BinaryTreePreorderTraversal_iterate {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            if (root == null) return result;
            Stack<TreeNode> tovisit = new Stack<>();
            tovisit.push(root);
            while (!tovisit.empty()) {
                TreeNode visiting = tovisit.pop();
                result.add(visiting.val);
                if (visiting.right != null) tovisit.push(visiting.right);
                if (visiting.left != null) tovisit.push(visiting.left);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution tool = new Solution();
        List<Integer> result = tool.preorderTraversal(root);
        System.out.println(result.toString());
    }
}
