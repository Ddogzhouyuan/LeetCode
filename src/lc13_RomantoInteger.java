import java.util.HashMap;

public class lc13_RomantoInteger {
    static class Solution {
        public int romanToInt(String s) {
            HashMap<Character, Integer> hashmap = new HashMap<>();
            hashmap.put('I', 1);
            hashmap.put('V', 5);
            hashmap.put('X', 10);
            hashmap.put('L', 50);
            hashmap.put('C', 100);
            hashmap.put('D', 500);
            hashmap.put('M', 1000);
            int n = s.length();
            int result = 0;
            if (n == 1) {
                result += hashmap.get(s.charAt(0));
            } else {
                for (int i = 0; i < n - 1; i++) {
                    if (hashmap.get(s.charAt(i)) < hashmap.get(s.charAt(i + 1))) {
                        result -= hashmap.get(s.charAt(i));
                    } else {
                        result += hashmap.get(s.charAt(i));
                    }
                }
                result += hashmap.get(s.charAt(n - 1));
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String s = "LVIII";
        Solution tool = new Solution();
        int result = tool.romanToInt(s);
        System.out.println(result);
    }
}
