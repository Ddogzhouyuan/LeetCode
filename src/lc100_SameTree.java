import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class lc100_SameTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null) return true;
            if(p == null || q == null) return false;
            if (q.val == p.val) {
                return isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
            } else {
                return false;
            }
        }

//        public List<Integer> preOrderTraverse(TreeNode root) {
//            List<Integer> result = new LinkedList<>();
//            Stack<TreeNode> stack = new Stack<>();
//            TreeNode cur = root;
//            while (cur != null || !stack.isEmpty()) {
//                if (cur != null) {
//                    result.add(cur.val);
//                    stack.push(cur);
//                    cur = cur.left;
//                } else {
//                    TreeNode node = stack.pop();
//                    cur = node.right;
//                }
//            }
//            return result;
//        }
//
//        public List<Integer> inOrderTraverse(TreeNode root) {
//            List<Integer> result = new LinkedList<>();
//            Stack<TreeNode> stack = new Stack<>();
//            TreeNode cur = root;
//            while (cur != null || !stack.isEmpty()) {
//                if (cur != null) {
//                    stack.push(cur);
//                    cur = cur.left;
//                } else {
//                    TreeNode node = stack.pop();
//                    result.add(node.val);
//                    cur = node.right;
//                }
//            }
//            return result;
//        }
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(20);
//        p.right.left = new TreeNode(15);
//        p.right.right = new TreeNode(7);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(20);
        Solution tool = new Solution();
        boolean result = tool.isSameTree(p, q);
        System.out.println(result);
    }
}
