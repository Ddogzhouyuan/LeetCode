import java.util.*;

public class lc145_BinaryTreePostorderTraversal_iterative {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            Deque<Integer> result = new LinkedList<>();
            if (root == null) return new LinkedList<>();
            Stack<TreeNode> tovisit = new Stack<>();
            tovisit.push(root);
            while (!tovisit.isEmpty()) {
                TreeNode visiting = tovisit.pop();
                result.addFirst(visiting.val);//reverse preorder
                if (visiting.left != null) tovisit.push(visiting.left);
                if (visiting.right != null) tovisit.push(visiting.right);
            }
            return new ArrayList<>(result);
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
