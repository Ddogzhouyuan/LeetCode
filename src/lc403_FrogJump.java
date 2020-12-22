import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc403_FrogJump {
    class Solution {
        public boolean canCross(int[] stones) {
            if (stones.length == 0) {
                return true;
            }
            HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>((int) (stones.length / 0.75 + 1));
            map.put(0, new HashSet<>());
            map.get(0).add(1);
            for (int i = 1; i < stones.length; i++) {
                map.put(stones[i], new HashSet<>());
            }
            for (int i = 0; i < stones.length - 1; i++) {
                int stone = stones[i];
                for (int step: map.get(stone)) {
                    int reach = step + stone;
                    if (reach == stones[stones.length - 1]) {
                        return true;
                    }
                    HashSet<Integer> set = map.get(reach);
                    if (set != null) {
                        set.add(step);
                        if (step - 1 > 0) {
                            set.add(step - 1);
                        }
                        set.add(step + 1);
                    }
                }
            }
            return false;
        }
    }
}
