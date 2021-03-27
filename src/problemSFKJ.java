import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class problemSFKJ {
    public class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int value) {
            this.val = value;
        }
    }

    public ArrayList<ArrayList<Integer>> getPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        dfs(result, temp, root, target);
        return result;
    }

    public ArrayList<ArrayList<Integer>> getPathIter(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

            }
        }
        return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, TreeNode root, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || root == null) {
            return;
        }
        int val = root.val;
        temp.add(val);
        dfs(result, temp, root.left, target - val);
        dfs(result, temp, root.right, target - val);
    }


}
