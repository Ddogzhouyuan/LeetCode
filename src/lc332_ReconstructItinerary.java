import java.util.*;

public class lc332_ReconstructItinerary {
    static class Solution {
        String initVertex = "JFK";

        public List<String> findItinerary(List<List<String>> tickets) {
            LinkedList<String> result = new LinkedList<>();
            if (tickets == null || tickets.size() == 0) return result;

            Map<String, PriorityQueue<String>> graph = new HashMap<>();
            for (List<String> ticket : tickets) {
                graph.putIfAbsent(ticket.get(0), new PriorityQueue<>(String::compareTo));
                graph.get(ticket.get(0)).add(ticket.get(1));
            }

            topologicalSort(initVertex, graph, result);
            return result;

        }

        public void topologicalSort(String vertex, Map<String, PriorityQueue<String>> graph, LinkedList<String> result) {
            PriorityQueue<String> queue = graph.get(vertex);
            while (queue != null && !queue.isEmpty()) {
                String adj = queue.poll();
                topologicalSort(adj, graph, result);
            }
            result.addFirst(vertex);
        }
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JKF", "SFO"));
        tickets.add(Arrays.asList("JFK", "ATL"));
        tickets.add(Arrays.asList("SFO", "ATL"));
        tickets.add(Arrays.asList("ATL", "JFK"));
        tickets.add(Arrays.asList("ATL", "SFO"));
        Solution tool = new Solution();
        List<String> result = tool.findItinerary(tickets);
        System.out.println(result.toString());
    }
}
