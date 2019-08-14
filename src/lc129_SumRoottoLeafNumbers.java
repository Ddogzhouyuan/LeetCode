import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc129_SumRoottoLeafNumbers {
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
        public int sumNumbers(TreeNode root) {
            if (root == null) return 0;
            List<List<String>> resultLs = new ArrayList<>();
            List<String> temp = new LinkedList<>();
            dfs(resultLs, temp, root);
            int result = 0;
            for (List i: resultLs) {
                result += Integer.valueOf(String.join("",i));
            }
            return result;
        }

        public void dfs(List<List<String>> resultLs, List<String> temp, TreeNode root) {
            if (root != null) {
                temp.add(String.valueOf(root.val));
            } else {
                return;
            }

            if (root.left == null && root.right == null) {
                resultLs.add(new LinkedList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            } else {
                dfs(resultLs, temp, root.left);
                dfs(resultLs, temp, root.right);
            }
            temp.remove(temp.size() - 1);
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
        int result = tool.sumNumbers(root);
        System.out.println(result);
    }
}
