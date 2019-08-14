import java.util.ArrayDeque;
import java.util.Deque;

public class lc388_LongestAbsoluteFilePath {
    static class Solution {
        public int lengthLongestPath(String input) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            int maxLen = 0;
            for (String s : input.split("\n")) {
                int lev = s.lastIndexOf("\t") + 1;
                while (lev + 1 < stack.size()) stack.pop();
                int len = stack.peek() + s.length() - lev + 1;
                stack.push(len);
                if (s.contains(".")) maxLen = Math.max(maxLen, len - 1);
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        Solution tool = new Solution();
        int result = tool.lengthLongestPath(input);
        System.out.println(result);
    }
}
