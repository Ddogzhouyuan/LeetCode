import java.util.ArrayList;
import java.util.List;

public class lc113_PathSumII {
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            List<Integer> temp = new ArrayList<>();
            backtrack2(result, temp, root, 0, sum);
            return result;
        }

        public void backtrack(List<List<Integer>> result, List<Integer> temp, TreeNode root, int sum) {
            if (root != null) {
                temp.add(root.val);
            } else {
                return;
            }

            if (root.left == null && root.right == null && root.val == sum) {
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            } else {
                backtrack(result, temp, root.left, sum - root.val);
                backtrack(result, temp, root.right, sum - root.val);
            }
            temp.remove(temp.size() - 1);
        }

        public void backtrack2(List<List<Integer>> result, List<Integer> temp, TreeNode root,int temp_sum , int sum) {
            if (root != null) {
                temp.add(root.val);
                temp_sum += root.val;
            } else {
                return;
            }

            if (root.left == null && root.right == null && temp_sum == sum) {
                result.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                temp_sum -= root.val;
                return;
            } else {
                backtrack2(result, temp, root.left, temp_sum, sum);
                backtrack2(result, temp, root.right, temp_sum, sum);
            }
            temp.remove(temp.size() - 1);
            temp_sum -= root.val;
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
        int sum = 22;
        Solution tool = new Solution();
        List<List<Integer>> result = tool.pathSum(root, sum);
        for (List i: result) {
            System.out.println(i.toString());
        }
    }
}
