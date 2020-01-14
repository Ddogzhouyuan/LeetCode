public class lc318_MaximumProductofWordLengths {
    static class Solution {
        public int maxProduct(String[] words) {
            int n = words.length;
            int[] bits = new int[n];
            for (int i = 0; i < n; i++) {
                int value = 0;
                char[] wordArr = words[i].toCharArray();
                for (int j = 0; j < wordArr.length; j++) {
                    value |= 1 << (wordArr[j] - 'a');
                }
                bits[i] = value;
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if ((bits[i] & bits[j]) == 0) {
                        result = Math.max(result, words[i].length() * words[j].length());
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        Solution tool = new Solution();
        int result = tool.maxProduct(words);
        System.out.println(result);
    }
}
