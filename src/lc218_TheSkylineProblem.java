import java.util.*;

public class lc218_TheSkylineProblem {
    static class Solution {
        class E {
            int x, y;
            boolean left;
            public E(int X, int Y, boolean Left) {
                x = X;
                y = Y;
                left = Left;
            }
        }

        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> result = new ArrayList<>();
            if (buildings == null || buildings.length == 0) return result;

            PriorityQueue<E> queue = new PriorityQueue<>(new Comparator<E>() {
                @Override
                public int compare(E e1, E e2) {
                    if (e1.x != e2.x) return e1.x - e2.x;
                    if (e1.left != e2.left) return (e1.left) ? -1 : 1;
                    return (e1.left) ? e2.y - e1.y : e1.y - e2.y;
                }
            });

            for (int[] b: buildings) {
                queue.offer(new E(b[0], b[2], true));
                queue.offer(new E(b[1], b[2], false));
            }

            PriorityQueue<Integer> hs = new PriorityQueue<>(Comparator.reverseOrder());
            hs.offer(0);

            while (!queue.isEmpty()) {
                E e = queue.poll();
                if (e.left) {
                    if (hs.peek() < e.y) result.add(Arrays.asList(e.x, e.y));
                    hs.add(e.y);
                } else {
                    hs.remove(e.y);
                    if (hs.peek() < e.y) result.add(Arrays.asList(e.x, hs.peek()));
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        int[][] buildings = {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
        Solution tool = new Solution();
        List<List<Integer>> result = tool.getSkyline(buildings);
        for (List i: result) {
            System.out.println(i.toString());
        }
    }
}
