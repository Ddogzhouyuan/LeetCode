import static com.TreenodeUtil.*;

public class lc114_FlattenBinaryTreetoLinkedList {
    static class Solution {
        TreeNode prev = null;
        public void flatten(TreeNode root) {
            if (root == null) return;

            flatten(root.right);
            flatten(root.left);

            root.right = prev;
            root.left = null;
            prev = root;
        }
    }

    public static void main(String[] args) {
        String tree = "[1,2,5,3,4,null,6]";
        TreeNode root = stringToTreeNode(tree);
        prettyPrintTree(root);
        Solution tool = new Solution();
        tool.flatten(root);
        prettyPrintTree(root);
    }
}
