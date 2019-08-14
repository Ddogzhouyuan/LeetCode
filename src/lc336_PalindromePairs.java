import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc336_PalindromePairs {
    static class Solution {
        private static class TrieNode {
            TrieNode[] next;
            int index;
            List<Integer> list;
            TrieNode() {
                next = new TrieNode[26];
                index = -1;
                list = new ArrayList<>();
            }
        }

        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> result = new ArrayList<>();

            TrieNode root = new TrieNode();

            for (int i = 0; i < words.length; i++) {
                addword(root, words[i], i);
            }

            for (int i = 0; i < words.length; i++) {
                search(words, i, root, result);
            }

            return result;
        }

        private boolean isPalindrome(String word, int i, int j) {
            while (i < j) {
                if (word.charAt(i++) != word.charAt(j--)) return false;
            }
            return true;
        }

        private void addword(TrieNode root, String word, int index) {
            for (int i = word.length() - 1; i >= 0; i--) {
                int j = word.charAt(i) - 'a';

                if (root.next[j] == null) {
                    root.next[j] = new TrieNode();
                }

                if (isPalindrome(word, 0, i)) {
                    root.list.add(index);
                }

                root = root.next[j];
            }

            root.list.add(index);
            root.index = index;
        }

        private void search(String[] words, int i, TrieNode root, List<List<Integer>> result) {
            for (int j = 0; j < words[i].length(); j++) {
                if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                    result.add(Arrays.asList(i, root.index));
                }

                root = root.next[words[i].charAt(j) - 'a'];
                if (root == null) return;
            }

            for (int j: root.list) {
                if (i == j) continue;
                result.add(Arrays.asList(i, j));
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        Solution tool = new Solution();
        List<List<Integer>> result = tool.palindromePairs(words);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }
}
