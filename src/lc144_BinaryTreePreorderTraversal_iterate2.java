import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lc144_BinaryTreePreorderTraversal_iterate2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    result.add(cur.val);
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    TreeNode node = stack.pop();
                    cur = node.right;
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
        List<Integer> result = tool.preorderTraversal(root);
        System.out.println(result.toString());
    }
}
