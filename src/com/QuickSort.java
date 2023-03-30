package com;

import java.util.Random;

public class QuickSort {
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition2(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private static final Random RANDOM = new Random();
    private int partition2(int[] nums, int lo, int hi) {
        int randomIndex = RANDOM.nextInt(hi - lo + 1) + lo;
        swap(nums, lo, randomIndex);
        int l = lo;
        int r = hi;
        int pivot = nums[lo];
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l >= r) {
                break;
            }
            swap(nums, l, r);
        }
        swap(nums, lo, l);
        return l;
    }

    private int partition(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return lo;
        }
        int pivot = nums[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (nums[++i] < pivot) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] > pivot) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, j, lo);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
