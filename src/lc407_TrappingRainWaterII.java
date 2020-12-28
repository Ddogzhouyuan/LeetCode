import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class lc407_TrappingRainWaterII {
    static class Solution {
        public class Cell {
            int row;
            int col;
            int height;

            public Cell(int row, int col, int height) {
                this.row = row;
                this.col = col;
                this.height = height;
            }
        }

        public int trapRainWater(int[][] heightMap) {
            if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
                return 0;
            }

            PriorityQueue<Cell> queue = new PriorityQueue<>(1, new Comparator<Cell>() {
                @Override
                public int compare(Cell o1, Cell o2) {
                    return o1.height - o2.height;
                }
            });

            int m = heightMap.length;
            int n = heightMap[0].length;
            boolean[][] visit = new boolean[m][n];

            // Initially, add all the Cells which are on borders to the queue.
            for (int i = 0; i < m; i++) {
                visit[i][0] = true;
                visit[i][n - 1] = true;
                queue.offer(new Cell(i, 0, heightMap[i][0]));
                queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            }

            for (int i = 0; i < n; i++) {
                visit[0][i] = true;
                visit[m - 1][i] = true;
                queue.offer(new Cell(0, i, heightMap[0][i]));
                queue.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
            }

            // from the borders, pick the shortest cell visited and check its neighbors:
            // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
            // add all its neighbors to the queue.
            int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            int res = 0;
            while (!queue.isEmpty()) {
                Cell cell = queue.poll();
                for (int[] dir: dirs) {
                    int row = cell.row + dir[0];
                    int col = cell.col + dir[1];
                    if (row >= 0 && row < m && col >= 0 && col < n && !visit[row][col]) {
                        visit[row][col] = true;
                        res += Math.max(0, cell.height - heightMap[row][col]);
                        queue.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
                    }
                }
            }
            return res;
        }
    }
}
