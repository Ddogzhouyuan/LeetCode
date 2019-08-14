import java.util.LinkedList;
import java.util.List;

public class lc144_BinaryTreePreorderTraversal_recursive {
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
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
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
