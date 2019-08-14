import java.util.*;

public class lc127_WordLadder {
    static class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) return 0;
            Set<String> beginSet = new HashSet<>();
            Set<String> endSet = new HashSet<>();
            Set<String> visited = new HashSet<>();
            int len = 1;
            int strLen = beginWord.length();
            beginSet.add(beginWord);
            endSet.add(endWord);

            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                if (beginSet.size() > endSet.size()) {
                    Set<String> temp = beginSet;
                    beginSet = endSet;
                    endSet = temp;
                }

                Set<String> temp = new HashSet<>();
                for (String word : beginSet) {
                    char[] chs = word.toCharArray();

                    for (int i = 0; i < chs.length; i++) {
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            char old = chs[i];
                            chs[i] = ch;
                            String check = new String(chs);

                            if (endSet.contains(check)) return len + 1;

                            if (!visited.contains(check) && wordList.contains(check)) {
                                temp.add(check);
                                visited.add(check);
                            }
                            chs[i] = old;
                        }
                    }
                }
                beginSet = temp;
                len++;
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
