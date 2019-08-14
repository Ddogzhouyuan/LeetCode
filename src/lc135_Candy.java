import java.util.Arrays;

public class lc135_Candy {
    static class Solution {
        public int candy(int[] ratings) {
            if (ratings.length <= 1) return 1;
            int[] given = new int[ratings.length];
            Arrays.fill(given, 1);
            for (int i = 1; i < ratings.length ; i++) {
                if (ratings[i] > ratings[i - 1]) given[i] = given[i - 1] + 1;
            }
            for (int i = ratings.length - 1; i > 0; i--) {
                if (ratings[i] < ratings[i - 1]) given[i - 1] = Math.max(given[i] + 1, given[i - 1]);
            }
            int result = 0;
            for (int i = 0; i < given.length; i++) {
                result += given[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] ratings = {0,1,20,9,8,7,2};
        Solution tool = new Solution();
        int result = tool.candy(ratings);
        System.out.println(result);
    }
}
