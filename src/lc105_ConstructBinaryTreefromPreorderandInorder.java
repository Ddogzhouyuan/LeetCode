import java.util.Arrays;

import static com.TreenodeUtil.*;
public class lc105_ConstructBinaryTreefromPreorderandInorder {
    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            TreeNode root = helper(preorder, inorder);
            return root;
        }

        public TreeNode helper(int[] preorder, int[] inorder) {
            if (preorder.length == 1 || inorder.length == 1) {
                return new TreeNode(preorder[0]);
            } else if (preorder.length == 0 || inorder.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]);
            int inIndex = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == root.val) {
                    inIndex = i;
                }
            }
            int[] inleft = Arrays.copyOfRange(inorder, 0, inIndex);
            int[] inright;

            if (inIndex + 1 <= inorder.length) {
                inright = Arrays.copyOfRange(inorder, inIndex + 1, inorder.length);
            } else {
                inright = new int[0];
            }
            int[] preleft;
            int[] preright;
            if (1 + inleft.length <= preorder.length) {
                preleft = Arrays.copyOfRange(preorder, 1, 1 + inleft.length);
                preright = Arrays.copyOfRange(preorder, 1 + inleft.length, preorder.length);
            } else {
                preleft = new int[0];
                preright = new int[0];
            }
            root.left = helper(preleft, inleft);
            root.right = helper(preright, inright);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {1,2};
        int[] inorder = {2,1};
        Solution tool = new Solution();
        TreeNode root = tool.buildTree(preorder, inorder);
        prettyPrintTree(root);
    }
}
