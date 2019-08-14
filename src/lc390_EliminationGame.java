public class lc390_EliminationGame {
    static class Solution {
        public int lastRemaining(int n) {
            boolean left = true;
            int remain = n;
            int step = 1;
            int head = 1;

            while (remain > 1) {
                if (left || remain % 2 == 1) {
                    head = head + step;
                }
                remain = remain / 2;
                step = step * 2;
                left = !left;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        int n = 22;
        Solution tool = new Solution();
        int result = tool.lastRemaining(n);
        System.out.println(result);
    }
}
