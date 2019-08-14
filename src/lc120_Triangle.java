import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc120_Triangle {
    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int layer = triangle.size();
            int n = triangle.get(triangle.size() - 1).size();
            int[] minpath = new int[n];
            for (int i = 0; i < minpath.length; i++) {
                minpath[i] = triangle.get(layer - 1).get(i);
            }
            for (int layerth = layer - 2; layerth  >= 0; layerth--) {
                for (int i = 0; i <= layerth;  i++) {
                    minpath[i] = Math.min(minpath[i], minpath[i + 1]) + triangle.get(layerth).get(i);
                }
            }
            return minpath[0];
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        Solution tool = new Solution();
        int result = tool.minimumTotal(triangle);
        System.out.println(result);
    }
}
