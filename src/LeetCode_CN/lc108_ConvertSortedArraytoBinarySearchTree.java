package LeetCode_CN;

import com.TreenodeUtil.*;

public class lc108_ConvertSortedArraytoBinarySearchTree {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            TreeNode root = helper(nums, 0, nums.length - 1);
            return root;
        }

        private TreeNode helper(int[] nums, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, start, mid - 1);
            root.right = helper(nums, mid + 1, end);
            return root;
        }
    }
}
