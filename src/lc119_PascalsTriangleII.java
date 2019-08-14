import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc119_PascalsTriangleII {
    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = new ArrayList<>();
            int[] temp_old = new int[1];
            for (int i = 0; i <= rowIndex; i++) {
                int[] temp_new = new int[i + 1];
                temp_new[0] = 1;
                temp_new[temp_new.length - 1] = 1;
                if (i >= 2) {
                    for (int j = 1; j < temp_new.length - 1; j++) {
                        temp_new[j] = temp_old[j - 1] + temp_old[j];
                    }
                }
                temp_old = new int[temp_new.length];
                System.arraycopy(temp_new, 0, temp_old, 0, temp_new.length);
            }
            for (int i = 0; i < temp_old.length; i++) result.add(temp_old[i]);
            return result;
        }
    }

    public static void main(String[] args) {
        int rowIndex = 1;
        Solution tool = new Solution();
        List<Integer> result = tool.getRow(rowIndex);
        System.out.println(result.toString());
    }
}
