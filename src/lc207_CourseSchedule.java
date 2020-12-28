import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc207_CourseSchedule {
    static class Solution {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            for (int[] req: prerequisites) {
                Set<Integer> dependence = graph.getOrDefault(req[0], new HashSet<>());
                dependence.add(req[1]);
                graph.put(req[0], dependence);
            }

            while (!graph.isEmpty()) {
                Integer node = graph.keySet().iterator().next();
                if (hasCycle(node, new HashSet<>())) {
                    return false;
                }
            }
            return true;
        }

        private boolean hasCycle(Integer node, Set<Integer> currentPath) {
            currentPath.add(node);
            Set<Integer> nextNodes = graph.get(node);
            for (Integer next: nextNodes) {
                if (currentPath.contains(next)) {
                    return true;
                }
                if (graph.containsKey(next)) {
                    if (hasCycle(next, currentPath)) {
                        return true;
                    }
                }
            }
            graph.remove(node);
            return false;
        }
    }
}
