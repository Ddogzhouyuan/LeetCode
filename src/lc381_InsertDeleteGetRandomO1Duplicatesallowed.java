import java.util.*;

public class lc381_InsertDeleteGetRandomO1Duplicatesallowed {
    static class RandomizedCollection {
        Random random;
        List<Integer> list;
        Map<Integer, LinkedHashSet<Integer>> valToIndices;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            random = new Random();
            list = new ArrayList<>();
            valToIndices = new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            if (!valToIndices.containsKey(val)) {
                valToIndices.put(val, new LinkedHashSet<>());
            }
            valToIndices.get(val).add(list.size());
            list.add(val);
            return valToIndices.get(val).size() == 1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!valToIndices.containsKey(val) || valToIndices.get(val).isEmpty()) {
                return false;
            }

            int indexToRemove = valToIndices.get(val).iterator().next();
            int valueLast = list.get(list.size() - 1);

            list.set(indexToRemove, valueLast);
            list.remove(list.size() - 1);

            valToIndices.get(val).remove(indexToRemove);
            valToIndices.get(valueLast).add(indexToRemove);
            valToIndices.get(valueLast).remove(list.size());
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
