public class lc171_ExcelSheetColumnNumber {
    static class Solution {
        public int titleToNumber(String s) {
            int temp = 0;
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                temp = s.charAt(i) - 'A' + 1 ;
                result = 26 * result + temp;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String s = "AAA";
        Solution tool = new Solution();
        int result = tool.titleToNumber(s);
        System.out.println(result);
    }
}
