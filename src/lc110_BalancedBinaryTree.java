public class lc110_BalancedBinaryTree {
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
        int diff = -1;
        public boolean isBalanced(TreeNode root) {
            helper(root);
            return diff <= 1;
        }

        public int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = helper(root.left);
            int right = helper(root.right);
            diff = Math.max(diff, Math.abs(left - right));
            return 1 + Math.max(left, right);
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
        boolean result = tool.isBalanced(root);
        System.out.println(result);
    }
}
