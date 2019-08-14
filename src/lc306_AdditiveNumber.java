public class lc306_AdditiveNumber {
    static class Solution {
        public boolean isAdditiveNumber(String num) {
            if (num.length() <= 2) return false;
            int firstL = 0;
            boolean result = false;
            for (int i = 1; i < num.length() - 1; i++) {
                for (int j = i + 1; j <= num.length() - 1; j++) {
                    result = result || judge(num, firstL, i, j);
                }
            }
            return result;
        }

        public boolean judge(String num, int firstL, int mid, int secondR) {
            if (secondR == num.length()) return true;
            String firstStr = num.substring(firstL, mid);
            String secondStr = num.substring(mid, secondR);
            if ((firstStr.length() > 1 && firstStr.charAt(0) == '0') || (secondStr.length() > 1 && secondStr.charAt(0) == '0')) return false;
            long first = Long.valueOf(firstStr);
            long second = Long.valueOf(secondStr);
            String str = String.valueOf(first + second);
            if (secondR + str.length() <= num.length() && num.substring(secondR, secondR + str.length()).equals(str)) {
                return judge(num, mid, secondR, secondR + str.length());
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String num = "199111992";
        Solution tool = new Solution();
        boolean result = tool.isAdditiveNumber(num);
        System.out.println(result);
    }
}
