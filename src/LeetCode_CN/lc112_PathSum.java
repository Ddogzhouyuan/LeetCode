package LeetCode_CN;

import com.TreenodeUtil.*;

public class lc112_PathSum {
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            boolean result = false;
            if (root == null) {
                return result;
            }
            result = result || helper(root, root.val, sum, result);
            return result;
        }

        private boolean helper(TreeNode root, int cumSum, int target, boolean result) {
            if (root.left != null) {
                result =  result || helper(root.left, cumSum + root.left.val, target, result);
            }
            if (root.right != null) {
                result =  result || helper(root.right, cumSum + root.right.val, target, result);
            }
            if (root.left == null && root.right == null) {
                return result || cumSum == target;
            }
            return result;
        }
    }
}
