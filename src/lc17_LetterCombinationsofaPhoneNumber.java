import java.util.*;


public class lc17_LetterCombinationsofaPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        HashMap<Character, String[]> hashmap = new HashMap<>();
        res.add("");
        hashmap.put('0', new String[]{""});
        hashmap.put('1', new String[]{""});
        hashmap.put('2', new String[]{"a", "b", "c"});
        hashmap.put('3', new String[]{"d", "e", "f"});
        hashmap.put('4', new String[]{"g", "h", "i"});
        hashmap.put('5', new String[]{"j", "k", "l"});
        hashmap.put('6', new String[]{"m", "n", "o"});
        hashmap.put('7', new String[]{"p", "q", "r", "s"});
        hashmap.put('8', new String[]{"t", "u", "v"});
        hashmap.put('9', new String[]{"w", "x", "y", "z"});
        for (int i = 0; i < digits.length(); i++) {
            List<String> newList = new ArrayList<>();
            for (String str_i : hashmap.get(digits.charAt(i))) {
                for (String str_j : res) {
                    newList.add(str_j + str_i);
                }
            }
            res = new ArrayList<>(newList);
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        List<String> res = letterCombinations("234");
        System.out.println(res.toString());
    }
}
