public class problem_BD {
    public int[] merge(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < n1 + n2) {
            if (nums1[i] < nums2[j]) {
                res[k] = nums1[i];
                i++;
            } else {
                res[k] = nums2[j];
                j++;
            }
            k++;
        }
        return res;
    }
}
