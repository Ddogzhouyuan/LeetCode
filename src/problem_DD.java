public class problem_DD {
    public static void main(String[] args) {
        int[] nums = {4,5,6,3,2,1};
        sort(nums, 0, nums.length - 1);
        for (int num: nums) {
            System.out.println(num);
        }
    }

    private static void sort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int left = i;
        int right = j;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;

//        partition(nums, 0, n - 1);
        sort(nums, i, left - 1);
        sort(nums, left + 1, j);
    }

    private static int partition(int[] nums, int i, int j) {
        if (i >= j) {
            return i;
        }
        int l = i;
        int r = j;
        int pivot = nums[l];
        while (l < r) {
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            swap(nums, l, r);
        }
        swap(nums, i, r);
        return r;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
