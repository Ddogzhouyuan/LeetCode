import static com.TreenodeUtil.*;

public class lc404_SumofLeftLeaves_recur {
    static class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int ans = 0;
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    ans += root.left.val;
                } else {
                    ans += sumOfLeftLeaves(root.left);
                }
            }
            ans += sumOfLeftLeaves(root.right);
            return ans;
        }
    }

    public static void main(String[] args) {
        String treeStr = "[3,9,20,null,null,15,7]";
        TreeNode root = stringToTreeNode(treeStr);
        prettyPrintTree(root);
        Solution tool = new Solution();
        int result = tool.sumOfLeftLeaves(root);
        System.out.println(result);
    }
}
