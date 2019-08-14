import java.util.LinkedList;
import java.util.List;

public class lc145_BinaryTreePostorderTraversal_recursive {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            if (root == null) return result;
            helper(root, result);
            return result;
        }

        public void helper(TreeNode root, List<Integer> result) {
            if (root != null) {
                helper(root.left, result);
                helper(root.right, result);
                result.add(root.val);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution tool = new Solution();
        List<Integer> result = tool.postorderTraversal(root);
        System.out.println(result.toString());
    }
}
