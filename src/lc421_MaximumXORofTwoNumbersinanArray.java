public class lc421_MaximumXORofTwoNumbersinanArray {
    class Solution {
        class Trie {
            Trie[] children;
            public Trie() {
                children = new Trie[2];
            }
        }

        public int findMaximumXOR(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Trie root = new Trie();
            // init trie
            for (int num: nums) {
                Trie cur = root;
                for (int i = 31; i >= 0; i--) {
                    int curBit = (num >>> i) & 1;
                    if (cur.children[curBit] == null) {
                        cur.children[curBit] = new Trie();
                    }
                    cur = cur.children[curBit];
                }
            }

            int max = Integer.MIN_VALUE;
            for (int num: nums) {
                int cumSum = 0;
                Trie cur = root;
                for (int i = 31; i >= 0; i--) {
                    int curBit = (num >>> i) & 1;
                    if (cur.children[curBit ^ 1] != null) {
                        cumSum += (1 << i);
                        cur = cur.children[curBit ^ 1];
                    } else {
                        cur = cur.children[curBit];
                    }
                }
                max = Math.max(max, cumSum);
            }
            return max;
        }
    }
}
