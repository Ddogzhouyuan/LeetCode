import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class lc18_4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 4 && target == nums[0] + nums[1] + nums[2] + nums[3]) {
            res.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            return res;
        }
        for (int i = 0; i + 3 < nums.length; i++) {
            for (int i2 = i + 1; i2 + 2 < nums.length; i2++) {
                int j = i2 + 1, k = nums.length - 1;
                int target_new = target - nums[i] - nums[i2];
                while (j < k) {
                    if (target_new == nums[j] + nums[k]) {
                        res.add(Arrays.asList(nums[i], nums[i2], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;
                        while (j < k && nums[k] == nums[k + 1]) k--;
                    } else if (target_new < nums[j] + nums[k]) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        res  = new ArrayList<>(new HashSet<>(res));
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int target = -1;
        List<List<Integer>> res = fourSum(nums, target);
        for (List tmp: res) {
            System.out.println(tmp.toString());
        }
    }

}
