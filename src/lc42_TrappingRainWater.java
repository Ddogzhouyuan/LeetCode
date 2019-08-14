public class lc42_TrappingRainWater {
    static class Solution {
        public int trap(int[] height) {
            int i = 0;
            int j = height.length - 1;
            int plank = 0;
            int result = 0;
            while (i <= j) {
                plank = plank < Math.min(height[i], height[j]) ? Math.min(height[i], height[j]) : plank;
                result = height[i] < height[j] ? result + (plank - height[i++]) : result + (plank - height[j--]);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1};
        Solution tool = new Solution();
        int result = tool.trap(height);
        System.out.println(result);
    }
}
