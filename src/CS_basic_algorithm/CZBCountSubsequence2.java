package CS_basic_algorithm;

public class CZBCountSubsequence2 {
    static int countSubsequence(String s, String t, int range) {
        int m = s.length();
        int n = t.length();
        if (m == 0) {
            return 0;
        }
        int idSold = 0;
        int idSnew = 0;
        int idT = 0;
        int count = 0;
        int countChar = 0;
        int matchStart = 0;
        StringBuilder sb = new StringBuilder();
        while(idT < n && idSnew < m) {
            if (s.charAt(idSnew) == t.charAt(idT) && countChar == 0) {
                idSold = idSnew;
                idSnew++;
                idT++;
                matchStart = idSnew;
                countChar++;
                if (idT == n && idSnew <= m && countChar == n) {
                    count++;
                }
            } else if (s.charAt(idSnew) == t.charAt(idT) && idSnew - idSold <= range) {
                idSold = idSnew;
                idSnew++;
                idT++;
                countChar++;
                if (idT == n && idSnew <= m && countChar == n) {
                    count++;
                }
            } else if (s.charAt(idSnew) == t.charAt(idT) && idSnew - idSold > range) {
                break;
            } else {
                sb.append(s.charAt(idSnew++));
            }
        }
        sb.append(s.substring(idSnew));
        if (idSnew == n && count == 0) {
            return 0;
        } else if (count > 0) {
            return count + countSubsequence(sb.toString(), t, range);
        } else {
            return countSubsequence(s.substring(matchStart), t, range);
        }
    }

    public static void main(String[] args) {
        String s = "aabbcdcaa";
        String t = "aba";
        int range = 5;
        int result = countSubsequence(s, t, range);
        System.out.println(result);
    }
}
