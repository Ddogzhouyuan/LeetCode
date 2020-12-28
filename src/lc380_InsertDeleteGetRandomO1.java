import java.util.*;

public class lc380_InsertDeleteGetRandomO1 {
    static class RandomizedSet {
        private int cnt;
        private Map<Integer, Integer> map;
        private List<Integer> list;
        private Random random;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            cnt = 0;
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            cnt++;
            list.add(val);
            map.put(val, cnt - 1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int i = map.get(val);
            int last = list.get(cnt - 1);
            list.set(i, last);
            map.put(last, i);
            map.remove(val);
            list.remove(cnt - 1);
            cnt--;
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(cnt));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
