public class lc278_FirstBadVersion {
    public class Solution {
        boolean isBadVersion (int num) {
            return true;
        }
        public int firstBadVersion(int n) {
            int low = 1;
            int high = n;
            while (low < high) {
                int mid = low + (high - low) / 2;
                boolean type = isBadVersion(mid);
                if (type) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }
}
