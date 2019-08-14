import java.util.ArrayList;
import java.util.List;

public class lc111_MinimumDepthofBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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
        if (root == null || newNode == null) return;

        if (root.left == null) {
            root.left = newNode;
            return;
        } else if (root.right == null) {
            root.right = newNode;
            return;
        }

        int lrh = 0;
        int rrh = 0;
        TreeNode pNode = root.left;
        while (pNode != null) {
            lrh++;
            pNode = pNode.right;
        }

        pNode = root.right;
        while (pNode != null) {
            rrh++;
            pNode = pNode.right;
        }

        if (lrh != rrh) {
            addNode(root.right, newNode);
        } else {
            addNode(root.left, newNode);
        }
    }

    static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            List<Integer> result = new ArrayList<>();
            dfs(result, root, 0);
            int min_depth = Integer.MAX_VALUE;
            for (int i: result) {
                min_depth = Math.min(i, min_depth);
            }
            return min_depth;
        }

        public void dfs(List<Integer> result, TreeNode root, int depth) {
            if (root != null) {
                depth++;
            } else {
                return;
            }

            if (root.left == null && root.right == null) {
                result.add(depth);
                depth--;
            } else {
                dfs(result, root.left, depth);
                dfs(result, root.right, depth);
            }
            depth--;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        Solution tool = new Solution();
        int result = tool.minDepth(root);
        System.out.println(result);
    }
}
