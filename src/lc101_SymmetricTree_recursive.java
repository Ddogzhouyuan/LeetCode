public class lc101_SymmetricTree_recursive {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            return root == null || helper(root.left, root.right);
        }

        public boolean helper(TreeNode left, TreeNode right) {
            if (left == null || right == null) return left == right;
            if (left.val != right.val) return false;
            return helper(left.left, right.right) && helper(left.right, right.left);
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

    public static boolean hastwochild(TreeNode root) {
        return root.left != null && root.right != null;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,4,3};
        TreeNode root = CreateTreeFromArray(nums);
        Solution tool = new Solution();
        boolean result = tool.isSymmetric(root);
        System.out.println(result);
    }
}
