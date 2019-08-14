import java.util.Stack;

public class lc101_SymmetricTree_iterative {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;

            Stack<TreeNode> stack = new Stack<>();
            TreeNode left;
            TreeNode right;
            if (root.left != null) {
                if (root.right == null) return false;
                stack.push(root.left);
                stack.push(root.right);
            } else if (root.right != null) {
                return false;
            }

            while (!stack.isEmpty()) {
                if (stack.size() % 2 != 0) return false;
                right = stack.pop();
                left = stack.pop();
                if (left.val != right.val) return false;

                if (left.left != null) {
                    if (right.right == null) return false;
                    stack.push(left.left);
                    stack.push(right.right);
                } else if (right.right != null) return false;

                if (left.right != null) {
                    if (right.left == null) return false;
                    stack.push(left.right);
                    stack.push(right.left);
                } else if (right.left != null) return false;
            }

            return true;
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


    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,4,3};
        TreeNode root = CreateTreeFromArray(nums);
        Solution tool = new Solution();
        boolean result = tool.isSymmetric(root);
        System.out.println(result);
    }
}
