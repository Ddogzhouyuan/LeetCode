package com;

public class BinarySearch {
    public static int binarySearchLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l;
    }

    public static int binarySearchLeftRec(int[] nums, int target, int start, int end) {
        if (start >= end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (nums[mid] > target) {
            return binarySearchLeftRec(nums, target, start, mid - 1);
        } else if (nums[mid] < target) {
            return binarySearchLeftRec(nums, target, mid + 1, end);
        } else {
            return mid;
        }
    }

    /**
     * 常规迭代二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchNormal(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 寻找存在重复数据，左侧边界的二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchLeftBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                r = mid;
            }
        }
        return l;
    }
    /**
     * 寻找存在重复数据，右侧边界的二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchRightBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] == target) {
                l = mid + 1;
            }
        }
        return  l - 1;
    }

    private int binarySearchLeft(int[] nums, int target, int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (nums[mid] > target) {
            return binarySearchLeft(nums, target, start, mid);
        } else if (nums[mid] < target) {
            return binarySearchLeft(nums, target, mid + 1, end);
        } else {
            return binarySearchLeft(nums, target, start, mid);
        }
    }

    private int binarySearchRight(int[] nums, int target, int start, int end) {
        if (start == end) {
            return start - 1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] > target) {
            return binarySearchLeft(nums, target, start, mid);
        } else if (nums[mid] < target) {
            return binarySearchLeft(nums, target, mid + 1, end);
        } else {
            return binarySearchLeft(nums, target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 8, 11};
        int target = 3;
        int result = binarySearchLeftRec(nums, target, 1, nums.length - 1);
        System.out.println(result);
    }
}
