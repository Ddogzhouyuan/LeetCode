import java.util.*;

public class lc126_WordLadderII {
    static class Solution {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            if (wordList.size() == 0) return result;

            Queue<String> q = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();
            Set<String> unvisited = new HashSet<>(wordList);
            q.add(beginWord);
            unvisited.remove(beginWord);
            boolean found = false;

            //bfs
            while(!q.isEmpty()) {
                int size = q.size();
                for (int k = size - 1; k >= 0; k--) {
                    String word = q.poll();
                    for (int i = 0; i < word.length(); i++) {
                        char chs[] = word.toCharArray();
                        for (char c = 'a'; c <= 'z'; c++) {
                            chs[i] = c;
                            String newStr = new String(chs);
                            if (unvisited.contains(newStr)) {
                                if (!visited.contains(newStr)) {
                                    visited.add(newStr);
                                    q.add(newStr);
                                }

                                if (map.containsKey(newStr)) {
                                    map.get(newStr).add(word);
                                } else {
                                    List<String> l = new ArrayList<>();
                                    l.add(word);
                                    map.put(newStr, l);
                                }

                                if (newStr == endWord) found = true;
                            }
                        }
                    }
                }
                if (found) break;
                unvisited.removeAll(visited);
                visited.clear();
            }

            backTrace(endWord, beginWord);
            return result;
        }

        public void backTrace(String cur, String start) {
            if (cur == start) {
                list.add(0, start);
                result.add(new ArrayList<>(list));
                list.remove(0);
                return;
            }
            list.add(0, cur);
            if (map.get(cur) != null) {
                for (String s: map.get(cur)) {
                    backTrace(s, start);
                }
            }
            list.remove(0);
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        Solution tool = new Solution();
        List<List<String>> result = tool.findLadders(beginWord, endWord, wordList);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }
}
