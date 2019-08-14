import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc127_WordLadder_TLE {
    static class Solution {
        int count = 0;
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            int level = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    if (cur.equals(endWord)) return level + 1;
                    for (int j = 0; j < cur.length(); j++) {
                        char[] word = cur.toCharArray();
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            word[j] = ch;
                            String check = new String(word);
                            if (check != cur && wordList.contains(check)) {
                                queue.add(check);
                                wordList.remove(check);
                            }
                        }
                    }
                }
                level++;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String engWord = "cog";
        List<String> wordList = new LinkedList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        Solution tool = new Solution();
        int result = tool.ladderLength(beginWord, engWord, wordList);
        System.out.println(result);
    }
}
