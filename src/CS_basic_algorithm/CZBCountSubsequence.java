package CS_basic_algorithm;

public class CZBCountSubsequence {
    static int countSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m == 0) {
            return 0;
        }
        int idS = 0;
        int idT = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(idT < n && idS < m) {
            if (s.charAt(idS) == t.charAt(idT)) {
                idS++;
                idT++;
                if (idT == n && idS <= m) {
                    count++;
                }
            } else {
                sb.append(s.charAt(idS++));
            }
        }
        sb.append(s.substring(idS));
        if (count > 0) {
            return count + countSubsequence(sb.toString(), t);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String s = "aabbcdcaa";
        String t = "aba";
        int result = countSubsequence(s, t);
        System.out.println(result);
    }
}
