import java.util.Stack;

import static com.TreenodeUtil.*;

public class lc404_SumofLeftLeaves_iter {
    static class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return 0;
            int ans = 0;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left != null) {
                    if (node.left.left == null && node.left.right == null) {
                        ans += node.left.val;
                    } else {
                        stack.push(node.left);
                    }
                }
                if (node.right != null) {
                    if (node.right.left != null || node.right.right != null) {
                        stack.push(node.right);
                    }
                }
            }
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
