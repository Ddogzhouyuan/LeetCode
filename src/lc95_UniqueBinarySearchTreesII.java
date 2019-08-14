import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.TreenodeUtil.*;
public class lc95_UniqueBinarySearchTreesII {
    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new ArrayList<>();
            HashMap<String, List<TreeNode>> cache = new HashMap<>();
            List<TreeNode> result = helper(1, n, cache);
            return result;
        }

        public List<TreeNode> helper(int lo, int hi, HashMap<String, List<TreeNode>> cache) {
            if (lo > hi) {
                List<TreeNode> result = new ArrayList<>();
                result.add(null);
                return result;
            }

            if (lo == hi) return new ArrayList<>(Arrays.asList(new TreeNode(lo)));

            String key = String.valueOf(lo) + "-" + String.valueOf(hi);
            if (cache.containsKey(key)) return cache.get(key);

            List<TreeNode> result = new ArrayList<>();
            for (int i = lo; i <= hi; i++) {
                List<TreeNode> lefts = helper(lo, i - 1, cache);
                List<TreeNode> rights = helper(i + 1, hi, cache);

                for (TreeNode left: lefts) {
                    for (TreeNode right: rights) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }

            cache.put(key, result);
            return result;

        }
    }

    public static void main(String[] args) {
        int n = 5;
        Solution tool = new Solution();
        List<TreeNode> result = tool.generateTrees(n);
        for (TreeNode i: result) {
            System.out.println(treeNodeToString(i));
        }
    }
}
