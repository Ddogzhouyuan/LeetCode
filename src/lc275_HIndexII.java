public class lc275_HIndexII {
    static class Solution {
        public int hIndex(int[] citations) {
            if (citations == null || citations.length == 0) return 0;
            int i = 0;
            int j = citations.length - 1;
            int index_mid = 0;
            int mid = 0;
            while(i < j) {
                mid = i + (j - i) / 2;
                index_mid = citations.length - 1 - mid;
                if (index_mid + 1 > citations[mid]) {
                    i = mid + 1;
                } else if (index_mid + 1 < citations[mid]) {
                    j = mid;
                } else {
                    break;
                }
            }
            mid = i + (j - i) / 2;
            index_mid = citations.length - 1 - mid;
            int hindex = index_mid + 1;
            if (index_mid + 1 > citations[mid]) hindex = citations[mid];
            else hindex = index_mid + 1;
            return hindex;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,8,10};
        Solution tool = new Solution();
        int result = tool.hIndex(nums);
        System.out.println(result);
    }
}
