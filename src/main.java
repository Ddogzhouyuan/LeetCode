import java.util.Arrays;

public class main {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        int target_i = 0;
        for (int i = 0; i + 2 < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            target_i = target - nums[i];
            while (j < k) {
                if (j < k && Math.abs(target - nums[i] - nums[j] - nums[k]) < diff) {
                    diff = Math.abs(target - nums[i] - nums[j] - nums[k]);
                    res = nums[i] + nums[j] + nums[k];
                }
                if (target_i == nums[j] + nums[k]) {
                    return target;
                } else if (target_i > nums[j] + nums[k]) {
                    j++;
                    if (j < k && Math.abs(target - nums[i] - nums[j] - nums[k]) < diff) {
                        diff = Math.abs(target - nums[i] - nums[j] - nums[k]);
                        res = nums[i] + nums[j] + nums[k];
                    }
                } else {
                    k--;
                    if (j < k && Math.abs(target - nums[i] - nums[j] - nums[k]) < diff) {
                        diff = Math.abs(target - nums[i] - nums[j] - nums[k]);
                        res = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
	// write your code here
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        int res;
        res = threeSumClosest(nums, target);
    }
}
