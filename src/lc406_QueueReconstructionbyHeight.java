import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class lc406_QueueReconstructionbyHeight {
    static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1];
                }
            });
            List<int[]> result = new LinkedList<>();
            for (int[] person: people) {
                result.add(person[1], person);
            }
            return result.toArray(new int[people.length][]);
        }
    }

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Solution tool = new Solution();
        int[][] result = tool.reconstructQueue(people);
    }
}
