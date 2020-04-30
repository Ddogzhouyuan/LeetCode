import com.TreenodeUtil.*;

public class lc437_PathSumIII {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            return pathSumFrom(root, sum) + pathSum(root.right, sum) + pathSum(root.left, sum);
        }

        private int pathSumFrom(TreeNode node, int sum) {
            if (node == null) {
                return 0;
            }
            return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
        }
    }
}
