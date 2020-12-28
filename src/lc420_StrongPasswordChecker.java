public class lc420_StrongPasswordChecker {
    class Solution {
        public int strongPasswordChecker(String s) {
            if (s.length() < 2) {
                return 6 - s.length();
            }

            //Initialize the states, including current ending character(end), existence of lowercase letter(lower),
            // uppercase letter(upper), digit(digit) and number of replicates for ending character(end_rep)
            char end = s.charAt(0);
            boolean upper = end >= 'A' && end <= 'Z';
            boolean lower = end >= 'a' && end <= 'z';
            boolean digit = end >= '0' && end <= '9';

            //Also initialize the number of modification for repeated characters, total number needed
            // for eliminate all consequnce 3 same character by replacement(change),
            // and potential maximun operation of deleting characters(delete).
            // Note delete[0] means maximum number of reduce 1 replacement operation by 1 deletion
            // operation, delete[1] means maximun number of reduce 1 replacement by 2 deletion
            // operation, delete[2] is no use here.
            int endRep = 1;
            int change = 0;
            int[] delete = new int[3];

            for (int i = 1; i < s.length(); ++i) {
                if (s.charAt(i) == end) {
                    ++endRep;
                } else {
                    change += endRep / 3;
                    if (endRep / 3 > 0) {
                        ++delete[endRep % 3];
                    }
                    end = s.charAt(i);
                    upper = upper || end >= 'A' && end <= 'Z';
                    lower = lower || end >= 'a' && end <= 'z';
                    digit = digit || end >= '0' && end <= '9';
                    endRep = 1;
                }
            }
            change += endRep / 3;
            if (endRep / 3 > 0) {
                ++delete[endRep % 3];
            }
            //The number of replcement needed for missing of specific character(lower/upper/digit)
             int chechReq = (upper ? 0 : 1) + (lower ? 0 : 1) + (digit ? 0 : 1);

            if (s.length() > 20) {
                int del = s.length() - 20;
                if (del <= delete[0]) {
                    change -= del;
                } else if (del - delete[0] <= 2 * delete[1]) {
                    change -= delete[0] + (del - delete[0]) / 2;
                } else {
                    change -= delete[0] + delete[1] + (del - delete[0] - 2 * delete[1]) /3;
                }
                return del + Math.max(chechReq, change);
            }
            return Math.max(6 - s.length(), Math.max(chechReq, change));
        }
    }
}
