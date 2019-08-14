
public class lc168_ExcelSheetColumnTitle {
    static class Solution {
        public String convertToTitle(int n) {
            String temp = "";
            while (n > 0) {
                n--;
                temp += String.valueOf((char)('A' + n % 26));
                n /= 26;
            }
            String result = "";
            for (int i = temp.length() - 1; i >= 0; i--) {
                result += String.valueOf(temp.charAt(i));
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int n = 703;
        Solution tool = new Solution();
        String result = tool.convertToTitle(n);
        System.out.println(result);
    }
}
