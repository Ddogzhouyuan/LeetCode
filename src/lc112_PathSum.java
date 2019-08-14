public class lc112_PathSum {
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
        public boolean hasPathSum(TreeNode root, int sum) {
            boolean result = false;
            if (root == null) return result;
            result = result || backtrack(result, root.val, sum, root);
            return result;
        }

        public boolean backtrack(boolean result, int temp, int sum, TreeNode root) {
            if (root.left != null) {
                result = result || backtrack(result, temp + root.left.val, sum, root.left);
            }
            if (root.right != null) {
                result = result || backtrack(result, temp + root.right.val, sum, root.right);
            }

            if (root.left == null && root.right == null) {
                result = result || temp == sum;
            }
            return result;
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
        root.right.right.right = new TreeNode(1);
        int sum = 22;
        Solution tool = new Solution();
        boolean result = tool.hasPathSum(root, sum);
        System.out.println(result);

    }
}
