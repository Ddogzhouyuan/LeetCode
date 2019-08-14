import java.util.Arrays;

import static com.TreenodeUtil.*;
public class lc106_ConstructBinaryTreefromInorderandPostorderTraversal {
    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            TreeNode root = helper(inorder, postorder);
            return root;
        }

        public TreeNode helper(int[] inorder, int[] postorder) {
            if (postorder.length == 1 || inorder.length == 1) {
                return new TreeNode(postorder[0]);
            } else if (postorder.length == 0 || inorder.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postorder.length - 1]);
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
            int[] postleft;
            int[] postright;
            if (inleft.length <= postorder.length - 1) {
                postleft = Arrays.copyOfRange(postorder, 0, inleft.length);
                postright = Arrays.copyOfRange(postorder, inleft.length, postorder.length - 1);
            } else {
                postleft = new int[0];
                postright = new int[0];
            }
            root.left = helper(inleft, postleft);
            root.right = helper(inright, postright);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] inorder = {3,2,1};
        int[] postorder = {3,2,1};
        Solution tool = new Solution();
        TreeNode root = tool.buildTree(inorder, postorder);
        prettyPrintTree(root);
    }
}
