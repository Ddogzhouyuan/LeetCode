import java.util.ArrayList;
import java.util.List;

public class lc68_TextJustification {
    static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> lines = new ArrayList<>();

            int index = 0;
            while (index < words.length) {
                int count = words[index].length();
                int last = index + 1;
                while (last < words.length) {
                    if (words[last].length() + count + 1 > maxWidth) break;
                    count += words[last].length() + 1;
                    last++;
                }
                StringBuilder builder = new StringBuilder();
                builder.append(words[index]);
                int diff = last - index - 1;

                if (last == words.length || diff == 0) {
                    for (int i = index + 1; i < last; i++) {
                        builder.append(" ");
                        builder.append(words[i]);
                    }
                    for (int i = builder.length(); i < maxWidth; i++) {
                        builder.append(" ");
                    }
                } else {
                    int space = (maxWidth - count) / diff;
                    int r = (maxWidth - count) % diff;
                    for (int i = index + 1; i < last; i++) {
                        for (int k = space; k > 0; k--) {
                            builder.append(" ");
                        }
                        if (r > 0) {
                            builder.append(" ");
                            r--;
                        }
                        builder.append(" ");
                        builder.append(words[i]);
                    }
                }
                lines.add(builder.toString());
                index = last;
            }
            return lines;
        }
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        Solution tool = new Solution();
        List<String> result = tool.fullJustify(words, maxWidth);
        for (String i: result) {
            System.out.println(i);
        }
    }
}
