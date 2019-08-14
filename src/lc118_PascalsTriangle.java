import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc118_PascalsTriangle {
    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            if (numRows <= 0) return result;
            for (int i = 1; i <= numRows; i++) {
                int[] temp1 = new int[i];
                temp1[0] = 1;
                temp1[temp1.length - 1] = 1;
                if (i >= 3) {
                    temp = result.get(i - 2);
                    for (int j = 1; j < temp1.length - 1; j++) {
                        temp1[j] = temp.get(j - 1) + temp.get(j);
                    }
                }
                temp = new ArrayList<>();
                for (int j = 0; j < temp1.length; j++) temp.add(temp1[j]);
                result.add(temp);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int numRows = 9;
        Solution tool = new Solution();
        List<List<Integer>> result = tool.generate(numRows);
        for (List i: result) {
            System.out.println(i.toString());
        }
    }
}
