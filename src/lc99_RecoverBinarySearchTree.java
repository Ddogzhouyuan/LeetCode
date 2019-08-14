import static com.TreenodeUtil.*;

public class lc99_RecoverBinarySearchTree {
    static class Solution {

        TreeNode firstElement = null;
        TreeNode secondElement = null;
        TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

        public void recoverTree(TreeNode root) {
            inordertraversal(root);

            int temp = firstElement.val;
            firstElement.val = secondElement.val;
            secondElement.val = temp;
        }

        public void inordertraversal(TreeNode root) {
            if (root == null) return;

            inordertraversal(root.left);
            // Start of "do some business",
            // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
            if (firstElement == null && prevElement.val >= root.val) {
                firstElement = prevElement;
            }
            // If first element is found, assign the second element to the root (refer to 2 in the example above)
            if (firstElement != null && prevElement.val >= root.val) {
                secondElement = root;
            }
            prevElement = root;

            inordertraversal(root.right);
        }
    }

    public static void main(String[] args) {
        String tree = "[1,3,null,null,2]";
        TreeNode root = stringToTreeNode(tree);
        prettyPrintTree(root);
        Solution tool = new Solution();
        tool.recoverTree(root);
        prettyPrintTree(root);
    }
}
