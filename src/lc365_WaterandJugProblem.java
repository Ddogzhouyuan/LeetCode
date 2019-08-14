public class lc365_WaterandJugProblem {
    static class Solution {
        public boolean canMeasureWater(int x, int y, int z) {
            if (x + y < z) return false;
            if (x == z || y == z || x + y == z) return true;

            return z % getGCD(x, y) == 0;
        }

        public int getGCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        int x = 4;
        int y = 6;
        int z = 2;
        Solution tool = new Solution();
        boolean result = tool.canMeasureWater(x, y, z);
        System.out.println(result);
    }
}
