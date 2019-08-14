public class lc331_VerifyPreorderSerializationofaBinaryTree {
    static class Solution {
        public boolean isValidSerialization(String preorder) {
            String[] nodes = preorder.split(",");
            int diff = 1;
            for (String i: nodes) {
                if (--diff < 0) return false;
                if (!i.equals("#")) diff += 2;
            }

            return diff == 0;
        }
    }

    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        Solution tool = new Solution();
        boolean result = tool.isValidSerialization(s);
        System.out.println(result);
    }
}
