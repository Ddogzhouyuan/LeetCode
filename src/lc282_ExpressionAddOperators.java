import java.util.ArrayList;
import java.util.List;

public class lc282_ExpressionAddOperators {
    static class Solution {
        public List<String> addOperators(String num, int target) {
            List<String> result = new ArrayList<>();
            if (num == null || num.length() == 0) return result;
            help(result, "", num, target, 0, 0, 0);
            return result;
        }

        public void help(List<String> result, String path, String num, int target, int pos, long eval, long multi) {
            if (pos == num.length()) {
                if (target == eval) {
                    result.add(path);
                    return;
                }
            }
            for (int i = pos; i < num.length(); i++) {
                if (i != pos && num.charAt(pos) == '0') break;
                long cur = Long.parseLong(num.substring(pos, i + 1));
                if (pos == 0) {
                    help(result, path + String.valueOf(cur), num, target, i + 1, eval + cur, cur);
                } else {
                    help(result, path + "+" + String.valueOf(cur), num, target, i + 1, eval + cur, cur);
                    help(result, path + "-" + String.valueOf(cur), num, target, i + 1, eval - cur, -cur);
                    help(result, path + "*" + String.valueOf(cur), num, target, i + 1, eval - multi + multi * cur, multi * cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        String num = "132";
        int target = 6;
        Solution tool = new Solution();
        List<String> result = tool.addOperators(num, target);
        for (String i: result) {
            System.out.println(i);
        }
    }
}
