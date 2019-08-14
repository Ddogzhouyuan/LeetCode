import java.util.ArrayList;

public class lc299_BullsandCows {
    static class Solution {
        public String getHint(String secret, String guess) {
            int bull = 0;
            ArrayList<Character> secret_ls = new ArrayList<>();
            ArrayList<Character> guess_ls = new ArrayList<>();
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    bull++;
                } else {
                    secret_ls.add(secret.charAt(i));
                    guess_ls.add(guess.charAt(i));
                }
            }
            int cow = 0;
            for (int i = 0; i < guess_ls.size(); i++) {
                if (secret_ls.contains(guess_ls.get(i))) {
                    cow++;
                    secret_ls.remove(guess_ls.get(i));
                }
            }

            String result = String.valueOf(bull) + "A" + String.valueOf(cow) + "B";
            return result;
        }
    }

    public static void main(String[] args) {
        String secret = "12";
        String guess = "12";
        Solution tool = new Solution();
        String result = tool.getHint(secret, guess);
        System.out.println(result);
    }
}
