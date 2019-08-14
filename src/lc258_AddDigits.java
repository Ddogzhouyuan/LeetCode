public class lc258_AddDigits {
    static class Solution {
        public int addDigits(int num) {
            if(num==0)return 0;
            return num%9==0?9:num%9;
        }
    }

    public static void main(String[] args) {
        int num = 2341;
        Solution tool = new Solution();
        int result = tool.addDigits(num);
        System.out.println(result);
    }
}
