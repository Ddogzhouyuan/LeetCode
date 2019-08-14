import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class lc373_FindKPairswithSmallestSums {
    static class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums1.length == 0 || nums2.length == 0) return result;

            PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) + a.get(1) - b.get(0) - b.get(1));
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    pq.offer(Arrays.asList(nums1[i], nums2[j]));
                }
            }

            while (k > 0 && !pq.isEmpty()) {
                result.add(pq.poll());
                k--;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        Solution tool = new Solution();
        List<List<Integer>> result = tool.kSmallestPairs(nums1, nums2,k);
        for (List i: result) {
            System.out.println(i.toString());
        }
    }
}
