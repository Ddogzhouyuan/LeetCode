import java.util.ArrayList;
import java.util.List;

public class lc93_RestoreIPAddresses {
    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();
            int len = s.length();
            for (int i = 1; i <= 3; i++) {
                if (len - i > 9) continue;
                for (int j = i + 1; j <= i + 3; j++) {
                    if (len - j > 6) continue;
                    for (int k = j + 1; k <= j + 3 && k < len; k++) {
                        int a = Integer.parseInt(s.substring(0, i));
                        int b = Integer.parseInt(s.substring(i, j));
                        int c = Integer.parseInt(s.substring(j, k));
                        int d = Integer.parseInt(s.substring(k));
                        if (a > 255 || b > 255 || c > 255 || d > 255) continue;
                        String ip = String.valueOf(a) + "." + String.valueOf(b) + "." + String.valueOf(c) + "." + String.valueOf(d);
                        if (ip.length() < len + 3) continue;
                        result.add(ip);
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        Solution tool = new Solution();
        List<String> result = tool.restoreIpAddresses(s);
        for (String i: result) {
            System.out.println(i);
        }
    }
}
