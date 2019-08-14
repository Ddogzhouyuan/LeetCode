import java.util.LinkedList;
import java.util.Queue;

public class lc337_HouseRobberIII {
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

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    static class Solution {
        int maxSum = Integer.MIN_VALUE;
        public int rob(TreeNode root) {
            if (root == null) return 0;
            helper(root, true);
            helper(root, false);
            return maxSum;
        }

        public int helper(TreeNode root, boolean type) {
            if (root == null) {
                return 0;
            }

            if (type) {
                int left = helper(root.left, !type);
                int right = helper(root.right, !type);
                maxSum = Math.max(left + right + root.val, maxSum);
                return left + right + root.val;
            } else {
                int left = Math.max(helper(root.left, !type), helper(root.left, type));
                int right = Math.max(helper(root.right, !type), helper(root.right, type));
                maxSum = Math.max(left + right, maxSum);
                return left + right;
            }
        }
    }

    public static void main(String[] args) {
        String tree = "[4,2,null,1,3]";
        TreeNode root = stringToTreeNode(tree);
        Solution tool = new Solution();
        int result = tool.rob(root);
        System.out.println(result);
    }
}
