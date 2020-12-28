import java.util.*;

public class lc399_EvaluateDivision {
    static class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, Map<String, Double>> m = new HashMap<>();
            for (int i = 0; i < values.length; i++) {
                m.putIfAbsent(equations.get(i).get(0), new HashMap<>());
                m.putIfAbsent(equations.get(i).get(1), new HashMap<>());
                m.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
                m.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
            }
            double[] r = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                r[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1, m, new HashSet<>());
            }
            return r;
        }

        public double dfs(String s, String t, double r, Map<String, Map<String, Double>> m, Set<String> seen) {
            if (!m.containsKey(s) || !seen.add(s)) {
                return -1;
            }
            if (s.equals(t)) {
                return r;
            }
            Map<String, Double> next = m.get(s);
            for (String c: next.keySet()) {
                double result = dfs(c, t, r * next.get(c), m, seen);
                if (result != -1) {
                    return result;
                }
            }
            return -1;
        }
    }
}
