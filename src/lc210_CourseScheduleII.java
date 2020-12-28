import java.util.*;

public class lc210_CourseScheduleII {
    static class Solution {
        class Node {
            int course;
            Set<Integer> ins = new HashSet<>();
            Set<Integer> outs = new HashSet<>();
            public Node(int c) {
                course = c;
            }
        }

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer> result = new ArrayList<>();
            Map<Integer, Node> map = new HashMap<>();

            // build up Nodes for every course than go over "prerequisites" to compute indegress and out degrees
            for (int i = 0; i < numCourses; i++) {
                map.put(i, new Node(i));
            }
            for (int[] edge: prerequisites) {
                int course = edge[0];
                int in = edge[1];
                map.get(course).ins.add(in);
                map.get(in).outs.add(course);
            }

            // only pick the Node with zero prerequisite or zero ins
            Queue<Node> queue = new LinkedList<>();
            for (Node n: map.values()) {
                if (n.ins.isEmpty()) {
                    queue.add(n);
                }
            }
            while (!queue.isEmpty()) {
                Node n = queue.poll();
                for (int out: n.outs) {
                    Node nextCourse = map.get(out);
                    nextCourse.ins.remove(n.course);
                    if (nextCourse.ins.isEmpty()) {
                        queue.add(nextCourse);
                    }
                }
                result.add(n.course);
            }

            // if there exist back edge course or a cycle than we can't take those courses
            return result.size() != numCourses ? new int[0] : result.stream().mapToInt(i -> i).toArray();
        }
    }
}
