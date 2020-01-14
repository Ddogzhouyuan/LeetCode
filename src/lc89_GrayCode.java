import java.util.ArrayList;
import java.util.List;

public class lc89_GrayCode {
    static class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            for (int i = 1; i <= n; i++) {
                int x = 1 << (i - 1);
                for (int j = x - 1; j >= 0; j--) {
                    list.add(list.get(j) | x);
                }
            }
            return list;
        }
    }
}
