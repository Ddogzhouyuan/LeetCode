public class lc165_CompareVersionNumbers {
    static class Solution {
        public int compareVersion(String version1, String version2) {
            String[] levels1 = version1.split("\\.");
            String[] levels2 = version2.split("\\.");

            int length = Math.max(levels1.length, levels2.length);
            for (int i = 0; i < length; i++) {
                int v1 = i < levels1.length ? Integer.valueOf(levels1[i]) : 0;
                int v2 = i < levels2.length ? Integer.valueOf(levels2[i]) : 0;
                if (v1 > v2) {
                    return 1;
                } else if (v1 < v2) {
                    return -1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        String version1 = "7.5.2.4";
        String version2 = "7.5.3";
        Solution tool = new Solution();
        int result = tool.compareVersion(version1, version2);
        System.out.println(result);
    }
}
