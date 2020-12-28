package LeetCode_CN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class lc350_IntersectionofTwoArraysII {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            if (n1 == 0 || n2 == 0) {
                return new int[0];
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            if (nums1[0] > nums2[n2 - 1] || nums1[n1 - 1] < nums2[0]) {
                return new int[0];
            }
            int i = 0;
            int j =  0;
            List<Integer> result = new LinkedList<>();
            while (i < n1 && j < n2) {
                int temp1 = nums1[i];
                int temp2 = nums2[j];
                if (temp1 < temp2) {
                    i++;
                } else if (temp1 > temp2) {
                    j++;
                } else {
                    result.add(temp1);
                    i++;
                    j++;
                }
            }
            return result.stream().mapToInt(a -> a).toArray();
        }
    }
}
