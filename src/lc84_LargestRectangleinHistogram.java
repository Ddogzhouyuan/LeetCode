import java.util.Stack;

public class lc84_LargestRectangleinHistogram {
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            if (heights.length == 0) return 0;
            Stack<Integer> stack = new Stack<>();
            int result = 0;
            int length = heights.length;
            for (int i = 0; i <= length; i++) {
                int h = i == length ? 0 : heights[i];
                while (!stack.isEmpty() && h < heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    int start = stack.isEmpty() ? -1 : stack.peek();
                    result = Math.max(result, height * (i - start - 1));
                }
                stack.push(i);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        Solution tool = new Solution();
        int result = tool.largestRectangleArea(heights);
        System.out.println(result);
    }
}
