import java.util.Arrays;
import java.util.HashMap;

/**
 * 未排序数组，求最长等差序列的长度，时间复杂度O(n)
 * 输入[100, 4, 200, 1,2,3,5],
 * 输出：5（[1,2,3,4,5]）
 */
public class problemTmp {
    public static int longestDiffSeq(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] - 1)) {
                map.put(nums[i], map.get(nums[i] - 1) + 1);
                result = Math.max(result, map.get(nums[i]));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {100, 4,200,1,2,3,5};
        int result = longestDiffSeq(nums);
        System.out.println(result);
    }
}
