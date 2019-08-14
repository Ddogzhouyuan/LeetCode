public class lc226_InvertBinaryTree {
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
        public TreeNode invertTree(TreeNode root) {
            helper(root);
            return root;
        }

        public void helper(TreeNode root) {
            if (root == null) return;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            helper(root.left);
            helper(root.right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,2,7,1,3,6,9};
        TreeNode root = CreateTreeFromArray(nums);
        Solution tool = new Solution();
        TreeNode result = tool.invertTree(root);
    }
}
