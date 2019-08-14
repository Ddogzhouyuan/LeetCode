import static com.TreenodeUtil.*;
public class lc222_CountCompleteTreeNodes {
    static class Solution {
        int count = 0;
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            dfs(root);
            return count;
        }

        public void dfs(TreeNode root) {
            if (root == null) {
                count--;
                return;
            }
            count++;
            if (root.left != null) dfs(root.left);
            if (root.right != null) dfs(root.right);
        }
    }

    public static void main(String[] args) {
        String tree = "[1,2,3,4,5,6]";
        TreeNode root = stringToTreeNode(tree);
        prettyPrintTree(root);
        Solution tool = new Solution();
        int result = tool.countNodes(root);
        System.out.println(result);
    }
}
