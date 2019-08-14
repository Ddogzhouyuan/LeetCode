import java.util.stream.IntStream;

public class lc134_GasStation {
    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            if (IntStream.of(cost).sum() > IntStream.of(gas).sum()) return -1;
            int startIndex = 0;
            int temp = 0;
            for (int i = 0; i < gas.length; i++) {
                temp = judgeStart(gas, cost, i);
                if (temp >= 0) {
                    startIndex = i;
                    break;
                }
            }
            return startIndex;
        }

        public int judgeStart(int[] gas, int[] cost, int start) {
            int tank = 0;
            for (int i = 0; i < gas.length; i++) {
                int index = i + start < gas.length ? i + start : i + start - gas.length;
                tank = tank + gas[index] - cost[index];
                if (tank < 0) return -1;
            }
            return tank;
        }
    }

    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        Solution tool = new Solution();
        int result = tool.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}
