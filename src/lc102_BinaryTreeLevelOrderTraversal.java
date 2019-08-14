import java.util.LinkedList;
import java.util.List;

public class lc102_BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            helper(root, 0, result);
            return result;
        }

        public void helper(TreeNode root, int depth, List<List<Integer>> result) {
            if (root == null) return;
            if (result.size() == depth) result.add(new LinkedList<Integer>());

            result.get(depth).add(root.val);
            helper(root.left, depth + 1, result);
            helper(root.right, depth + 1, result);
        }
    }

    public static TreeNode CreateTreeFromArray(int[] nums) {
        TreeNode root = new TreeNode(0);
        for (int i = 0; i <  nums.length; i++) {
            if (i == 0) {
                root.val = nums[i];
            } else {
                TreeNode temp = new TreeNode(nums[i]);
                addNode(root, temp);
            }
        }
        return root;
    }

    public static void addNode(TreeNode root, TreeNode newNode) {
        if (root.left == null && root.right == null)  {
            root.left = newNode;
        } else if (root.left != null && root.right == null) {
            root.right = newNode;
        } else {
            if (!hastwochild(root.left)) {
                addNode(root.left, newNode);
            } else if (!hastwochild(root.right)) {
                addNode(root.right, newNode);
            } else {
                addNode(root.left.left, newNode);
            }
        }
    }

    public static boolean hastwochild(TreeNode root) {
        return root.left != null && root.right != null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution tool = new Solution();
        List<List<Integer>> result = tool.levelOrder(root);
        for (List i: result) {
            System.out.println(i.toString());
        }
    }
}
