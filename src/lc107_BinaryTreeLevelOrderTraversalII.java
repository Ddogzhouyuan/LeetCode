import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc107_BinaryTreeLevelOrderTraversalII {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) return result;
            help(result, root, 1);
            List<List<Integer>> result2 = new LinkedList<>();
            for (int i = result.size() - 1; i >= 0; i--) {
                result2.add(result.get(i));
            }
            return result2;
        }

        public void help(List<List<Integer>> result, TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (depth <= result.size()) {
                result.get(depth - 1).add(root.val);
            } else {
                result.add(new LinkedList<>(Arrays.asList(root.val)));
            }
            help(result, root.left, depth + 1);
            help(result, root.right, depth + 1);
            depth--;
        }
    }

    public static void main(String[] args) {
        String tree = "[1,2,3,4,5]";
        TreeNode root = stringToTreeNode(tree);
        Solution tool = new Solution();
        List<List<Integer>> result = tool.levelOrderBottom(root);
        for (List i: result) {
            System.out.println(i.toString());
        }
    }
}
