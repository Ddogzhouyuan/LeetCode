package LeetCode_CN;

import com.TreenodeUtil.*;

public class lc104_MaximumDepthofBinaryTree {
    class Solution {
        int maxDepth = 0;
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            helper(root, 1);
            return maxDepth;
        }

        public void helper(TreeNode root, int curLevel) {
            if (root == null) {
                return;
            }
            if (root.right == null && root.left == null) {
                maxDepth = Math.max(curLevel, maxDepth);
            } else {
                helper(root.right, curLevel + 1);
                helper(root.left, curLevel + 1);
            }
        }
    }
}
